package com.maks.durov;

import org.apache.log4j.Logger;

public class FirstThread extends Thread {
    private final static Logger logger = Logger.getLogger(FirstThread.class);
    private final Counter counter;

    public FirstThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getValue() < counter.getMaxValue()) {
            counter.increment();
            logger.info(Thread.currentThread().getName()
                    + " (extends Thread) incremented value now it's: " + counter.getValue());
        }
        logger.info(Thread.currentThread().getName() + " (extends Thread) is finish!");
    }
}
