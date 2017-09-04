package com.sveak.howswap;

public class Test {

    public static JavaClassLoader loader;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> loader = new JavaClassLoader("C:\\Users\\kuoka\\IdeaProjects\\classloader\\src\\main\\resources",""));
        thread.start();

        Logic logic = new Logic();

        logic.load();
        logic = null;

        Logic l = new Logic();
        l.load();
    }


}
