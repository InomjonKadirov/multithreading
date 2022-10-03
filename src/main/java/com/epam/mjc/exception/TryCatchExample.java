package com.epam.mjc.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TryCatchExample implements Runnable {
    @Override
    public void run() {
        try {
            throw new RuntimeException("Run err...");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Thread err warning....");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new TryCatchExample()).start();
        Thread.sleep(1000);

        new Thread(new TryCatchExample()).start();
        Thread.sleep(1000);
    }
}
