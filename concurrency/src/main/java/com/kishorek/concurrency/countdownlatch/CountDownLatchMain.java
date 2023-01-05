package com.kishorek.concurrency.countdownlatch;

import com.kishorek.concurrency.countdownlatch.tasks.APICallTask;
import com.kishorek.concurrency.countdownlatch.tasks.BaseTask;
import com.kishorek.concurrency.countdownlatch.tasks.EmailTask;
import com.kishorek.concurrency.countdownlatch.tasks.FileDownloadTask;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchMain {
    public static void main(String[] args) throws InterruptedException {

        // Run all the three tasks in threads
        runAllTasks();

        // Run all the three tasks in thread with CountDownLatch
        runAllTasksWithCountDownLatch();
    }

    public static void runAllTasks(){
        CountDownLatch latch = new CountDownLatch(3);
        List<BaseTask> tasks = createTasks(latch);
        for(BaseTask task:tasks){
            new Thread(task).start();
        }

        System.out.println("All tasks are done. Proceed to next stage!");
    }

    public static void runAllTasksWithCountDownLatch() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        List<BaseTask> tasks = createTasks(latch);
        for(BaseTask task:tasks){
            new Thread(task).start();
        }

        latch.await();

        System.out.println("All tasks are done. Proceed to next stage!");
    }

    private static List<BaseTask> createTasks(CountDownLatch latch){
        APICallTask apiCallTask = new APICallTask(latch);
        FileDownloadTask fileDownloadTask = new FileDownloadTask(latch);
        EmailTask emailTask = new EmailTask(latch);

        return Arrays.asList(new BaseTask[]{apiCallTask, fileDownloadTask, emailTask});
    }
}
