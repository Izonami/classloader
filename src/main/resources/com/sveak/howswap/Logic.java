package com.sveak.howswap;

import java.util.Scanner;

public class Logic {

    public void load() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            final String command = scanner.next();

            if(command.equalsIgnoreCase("reload")) {
                try {
                    Test.loader.loadClass("com.sveak.howswap.Logic");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else print(command+"jopa");
        }
    }

    private void print(String text) {
        System.out.println(text);
    }
}
