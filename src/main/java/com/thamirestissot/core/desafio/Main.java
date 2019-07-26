package com.thamirestissot.core.desafio;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("inicio");
        HandlerFile handlerFile=new HandlerFile();
        try {
            handlerFile.readDirectory("/data/in");
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*Watcher watcher= new Watcher();
        try {
            watcher.monitora("/data/in");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("fim");
    }
}
