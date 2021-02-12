package ru.mirea;

public class Main {

    public static void main(String[] args) {
        Singleton1 s1 = Singleton1.getInstance();
        Singleton1 s1e = Singleton1.getInstance();
        Singleton2 s2 = Singleton2.getInstance();
        Singleton2 s2e = Singleton2.getInstance();
        Singleton3 s3 = Singleton3.getInstance();
        Singleton3 s3e = Singleton3.getInstance();
        Singleton4 s4 = Singleton4.getInstance();
        Singleton4 s4e = Singleton4.getInstance();
        Singleton5 s5 = Singleton5.getInstance();
        Singleton5 s5e = Singleton5.getInstance();
        System.out.println(s1);
        System.out.println(s1e);
        System.out.println(s2);
        System.out.println(s2e);
        System.out.println(s3);
        System.out.println(s3e);
        System.out.println(s4);
        System.out.println(s4e);
        System.out.println(s5);
        System.out.println(s5e);
    }
}
