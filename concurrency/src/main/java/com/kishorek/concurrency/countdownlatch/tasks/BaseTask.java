package com.kishorek.concurrency.countdownlatch.tasks;

import java.util.concurrent.CountDownLatch;

public abstract class BaseTask implements Runnable{
    private CountDownLatch latch;

    private TaskStatus status;

    public BaseTask(CountDownLatch latch){
        this.latch = latch;
        this.status = TaskStatus.NotStarted;
    }

    @Override
    public void run() {
        this.performTask();
        this.latch.countDown();
    }

    public abstract void performTask();

    public CountDownLatch getLatch() {
        return latch;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}

enum TaskStatus{
    NotStarted, InProgress, Completed
}
