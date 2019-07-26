package com.thamirestissot.core.desafio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HandlerFile {
    public static void readDirectory(String path) throws IOException {

        Files.list(Paths.get(System.getProperty("user.home") + path)).filter(Files::isRegularFile).forEach(path1 -> readFile(String.valueOf(path1)));

        //Files.list(Paths.get(System.getProperty("user.home")+path)).filter(Files::isRegularFile).forEach(System.out::println);
    }

    public static void readFile(String path) {
        File file = new File(path);
        try (
                Scanner scnr = new Scanner(file)
        ) {
            System.out.println(path);
            while (scnr.hasNextLine()) {
                prprocessLine(scnr.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }

    }

    public static void prprocessLine(String line){
        System.out.println("**"+line+"**");
        String separator = String.valueOf(line.charAt(3));
        String[] words= line.split(separator);

        List<DataType> dataTypes = Arrays.asList(DataType.values());
        for (DataType dataType:dataTypes ) {
            if (dataType.getCode()==Integer.parseInt(words[0])){

            }

        }

    }
}
