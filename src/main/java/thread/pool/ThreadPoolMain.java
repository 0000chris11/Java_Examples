package thread.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

class ThreadPoolMain {

    ThreadPoolMain(String[] args) throws InterruptedException, ExecutionException {
        if (args[0].equals("1")) {
            // EXAMPLE 1 (SINGLE THREAD)-----------------
            Executor executor = Executors.newSingleThreadExecutor();
            executor.execute(() -> System.out.println("SingleThread start"));

        } else if (args[0].equals("2")) {
            // EXAMPLE 2 (SIMPLE STRING STORE FOR LATER)-----------
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            Future<String> future = executorService.submit(() -> "Submit 1");

            System.out.println("future result: " + future.get());

        } else if (args[0].equals("3")) {
            System.out.println("EXAMPLE 3 ()");
            ThreadPoolExecutor executor2 = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
            executor2.submit(() -> {
                Thread.sleep(1000);
                System.out.println("thread 1 finished");
                return null;
            });
            executor2.submit(() -> {
                Thread.sleep(1000);
                System.out.println("thread 2 finished");
                return null;
            });
            executor2.submit(() -> {
                Thread.sleep(1000);
                System.out.println("thread 3 finished");
                return null;
            });
        }

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        new ThreadPoolMain(args);
    }
}
