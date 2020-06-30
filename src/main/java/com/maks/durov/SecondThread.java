package com.maks.durov;

import org.apache.log4j.Logger;

public class SecondThread implements Runnable {
    private final static Logger logger = Logger.getLogger(SecondThread.class);
    private final Counter counter;

    public SecondThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        while (counter.getValue() < counter.getMaxValue()) {
            counter.increment();
            logger.info(Thread.currentThread().getName() + " (implements Runnable) incremented value now it's: "
                    + counter.getValue());
        }
        logger.info(Thread.currentThread().getName() + " (implements Runnable) is finish!");

    }
}
