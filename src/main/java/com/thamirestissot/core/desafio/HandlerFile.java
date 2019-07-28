package com.thamirestissot.core.desafio;

import com.thamirestissot.core.desafio.exceptions.InfoCodeNotRegisteredException;
import com.thamirestissot.core.desafio.exceptions.NoHasPossibleReadFileConfigurationException;
import com.thamirestissot.core.desafio.exceptions.DirectoryNotFoundException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static com.thamirestissot.core.desafio.DataType.*;

public class HandlerFile {
    private final String HOMEPATH, INPATH, OUTPATH;

    public HandlerFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            HOMEPATH = System.getProperty(properties.getProperty("homePath"));
            INPATH = HOMEPATH + properties.getProperty("inPath");
            OUTPATH = HOMEPATH + properties.getProperty("outPath");
        } catch (IOException e) {
            throw new NoHasPossibleReadFileConfigurationException("src/main/resources/config.properties");
        }
    }

    public List<String> readDirectory() throws IOException {
        if (checkExists(INPATH)) {
            List<String> fileNames = new ArrayList<String>();
            Files.list(Paths.get(INPATH)).filter(Files::isRegularFile).forEach(path1 -> {
                fileNames.add(String.valueOf(path1.getFileName()));
            });
            return fileNames;
        }
        throw new DirectoryNotFoundException(INPATH);
    }

    public boolean checkExists(String path) {
        return (Files.exists(Paths.get(path)));
    }

    public List<String> readFile(String pathFile) {
        List<String> lines = new ArrayList<String>();
        File file = new File(pathFile);
        try (
                Scanner scanner = new Scanner(file)
        ) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        return lines;
    }

    public Object processLine(String line) throws InfoCodeNotRegisteredException {
        String separator = String.valueOf(line.charAt(3));
        String[] words = line.split(separator);
        int codeLine = Integer.parseInt(words[0]);
        if (SALESMAN.getCode() == codeLine) {
            return new Salesman(words[1], words[2], Double.parseDouble(words[3]));
        } else if (CUSTOMER.getCode() == codeLine) {
            return new Customer(words[1], words[2], words[3]);
        } else if (SALE.getCode() == codeLine) {
            words[2] = words[2].replace("[", "");
            words[2] = words[2].replace("]", "");
            String[] items = words[2].split(",");
            List<SaleItem> saleItem = new ArrayList<SaleItem>();
            for (String item : items) {
                String[] attributeItem = item.split("-");
                Item item1 = new Item(Integer.parseInt(attributeItem[0]), Double.parseDouble(attributeItem[2]));
                saleItem.add(new SaleItem(item1, Integer.parseInt(attributeItem[1])));

            }
            return new Sale(Integer.parseInt(words[1]), saleItem, words[3]);
        }
        throw new InfoCodeNotRegisteredException();
    }

    public void processFile(String nameFile) {
        try {
            List<Object> objects = new ArrayList<Object>();
            readFile(INPATH + nameFile).stream().forEach(line -> {
                objects.add(processLine(line));
            });
            createReportFile(makeReport(objects),nameFile);
        } catch (InfoCodeNotRegisteredException e) {
            System.out.println(e.getFriendlyMessage());
        }
    }

    private Report makeReport(List<Object> objects) {

        List<Salesman> salesmen = getList(objects, Salesman.class);
        List<Customer> customers = getList(objects, Customer.class);
        List<Sale> sales = getList(objects, Sale.class);
        int numberOfCustomers = customers.size();
        int numberOfSalesmen = salesmen.size();
        int mostExpensiveSaleId=-1;
        String worstSalesmanEver = "";
        if (!sales.isEmpty()) {
            Collections.sort(sales);
            mostExpensiveSaleId = sales.get(0).getId();
            for (Sale sale : sales) {
                salesmen.stream().filter(salesman -> salesman.getName().equals(sale.getSalesmanName()))
                        .forEach(salesman -> salesman.addSale());
            }
            Collections.sort(salesmen);
            worstSalesmanEver = salesmen.get(0).getName();
        }
        return new Report(numberOfCustomers,numberOfSalesmen,mostExpensiveSaleId,worstSalesmanEver);
    }

    private void createReportFile(Report report, String nameFile){
        try (FileWriter fileWriter =new FileWriter(OUTPATH+nameFile,false)){
            fileWriter.write(report.getMessageReport());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <E> List<E> getList(List<Object> list, Class myclass) {
        return list.stream().filter(o -> o.getClass() == myclass).map(o -> (E) o).collect(Collectors.toList());
    }

    public String getHOMEPATH() {
        return HOMEPATH;
    }

    public String getINPATH() {
        return INPATH;
    }

    public String getOUTPATH() {
        return OUTPATH;
    }
}
