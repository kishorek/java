package com.kishorek.concurrency.countdownlatch.tasks;

import java.util.concurrent.CountDownLatch;


public class APICallTask extends BaseTask{
    public APICallTask(CountDownLatch latch){
        super(latch);
    }

    @Override
    public void performTask() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All the API calls are done successfully");
    }
}
