package com.thamirestissot.core.desafio.dataManipulation;

import com.thamirestissot.core.desafio.model.Report;
import com.thamirestissot.core.desafio.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.thamirestissot.core.desafio.model.DataType.*;

public class HandlerData {

    public Object processLine(String line) {
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
        throw new RuntimeException("Info code not registered.");
    }

    public Report processContent(String FileContent) {
        String fileLines[] = FileContent.split("\n");

        List<Object> data = new ArrayList<Object>();
        Arrays.stream(fileLines).forEach(line -> data.add(processLine(line)));

        return new Report(data);
    }
}