package com.kishorek.concurrency.countdownlatch.tasks;

import java.util.concurrent.CountDownLatch;

public class FileDownloadTask extends BaseTask{
    public FileDownloadTask(CountDownLatch latch){
        super(latch);
    }
    @Override
    public void performTask() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Files are downloaded successfully");
    }
}
