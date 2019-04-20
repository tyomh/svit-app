package com.svit.java.l8;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * Define and execute three tasks(e.g task1, task2, task3) 
 * task1 starts with initial delay 1 seconds, and 1 seconds delay subsequently delay between the termination of last execution and the next execution；
 * task2 starts with initial delay 2 seconds, and 2 seconds delay subsequently delay between the termination of last execution and the next execution；
 * task3 starts with initial delay 3 seconds, and 3 seconds delay subsequently delay between the termination of last execution and the next execution；
 * 
 * Each task runs again and again until cancellation or termination. If any execution of the task encounters an exception, subsequent executions are suppressed. 
 * 
 * Hint: use Java's ScheduledExecutorService and scheduleAtFixedRate method.
 * 
 * Code is for study and personal use purpose, not for commercial use.
 * 
 * @author sv-it.org
 *
 */
public class ScheduledTask {
    private static long START_TIME;

    public static void main(String[] args) throws InterruptedException {

//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
//
//        START_TIME = System.currentTimeMillis();
//        Runnable task1 = printTask("T1");
//        Runnable task2 = printTask("T2");
//        Runnable task3 = printTask("T3");
//
//        scheduledExecutorService.scheduleAtFixedRate(task1, 1, 1, TimeUnit.SECONDS);
//        scheduledExecutorService.scheduleAtFixedRate(task2, 2, 2, TimeUnit.SECONDS);
//        scheduledExecutorService.scheduleAtFixedRate(task3, 3, 3, TimeUnit.SECONDS);
//
//        Thread.sleep(15000);
//        scheduledExecutorService.shutdown();
//        scheduledExecutorService.awaitTermination(6000, TimeUnit.SECONDS);
//    }
//
//    private static Runnable printTask(String prefix) {
//        return () -> System.out.println(prefix + ": " + (System.currentTimeMillis() - START_TIME));
//    }
    	
        long time = System.nanoTime();
        try {
            scheduledTasks(time);
        } catch (Exception e){
            return;
        }
    }

    private static void scheduledTasks(long time) throws InterruptedException{

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
        Runnable t1 = () -> System.out.println("Scheduling T1: " + (System.nanoTime() - time));
        Runnable t2 = () -> System.out.println("Scheduling T2: " + (System.nanoTime() - time));
        Runnable t3 = () -> System.out.println("Scheduling T3: " + (System.nanoTime() - time));
        ses.scheduleAtFixedRate(t1, 1, 1, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate(t2, 2, 2, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate(t3, 3, 3, TimeUnit.SECONDS);
        //Thread.sleep();
        //ses.shutdown();
        ses.awaitTermination(20, TimeUnit.SECONDS);
    }
}
