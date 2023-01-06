package com.kishorek.concurrency.countdownlatch.tasks;

import java.util.concurrent.CountDownLatch;

public class EmailTask extends BaseTask{
    public EmailTask(CountDownLatch latch){
        super(latch);
    }

    @Override
    public void performTask() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Email is sent successfully");
    }
}
