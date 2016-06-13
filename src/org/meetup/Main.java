package org.meetup;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        //System.out.println(args[0]);


        ExecutorService executor= Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
        try {
            System.out.println("wait 1 sec");
            TimeUnit.SECONDS.sleep(10);
            return 123;

        }
        catch (InterruptedException e) {
            throw new IllegalStateException("Task interrupted", e);
        }};

        Future<Integer> submit = executor.submit(task);

//        while (!submit.isDone()){
//            System.out.println("Not yet");
//        }
        System.out.println(submit.get(11,TimeUnit.SECONDS));

    }
}
