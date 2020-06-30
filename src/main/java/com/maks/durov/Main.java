package com.maks.durov;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter(0, 100);
        Thread firstThread = new FirstThread(counter);
        Thread secondThread = new Thread(new SecondThread(counter));
        firstThread.start();
        secondThread.start();
    }
}
