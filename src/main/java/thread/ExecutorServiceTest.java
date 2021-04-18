package thread;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // WAITS BEFORE THE LONGEST THREAD TO FINISH FIRST THAN EXECUTE THE OTHERS
        Scanner sc = new Scanner(System.in);
        System.out.println("CHOOSE");
        int n = sc.nextInt();

        if (n == 1) {
            ExecutorService executor = Executors.newFixedThreadPool(2);
            Future<String> task1 = executor.submit(new CallableImpl(1000, "Xmas in Rio"));
            Future<?> task2 = executor.submit(new RunnableImpl());

            while (!task1.isDone() && !task2.isDone()) {
                // ???????????????????????
                System.out.println("Waiting for task1 and task2 to finished");
            }

            System.out.println("ReturnValue task1: " + task1.get());
            System.out.println("ReturnValue task2: " + task2.get());
        } else if (n == 2) {
            final int nThread = 2;
            ExecutorService executor = Executors.newFixedThreadPool(nThread);
            ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executor);
            completionService.submit(new CallableImpl(3000, "Ending of the Year"));
            completionService.submit(new CallableImpl(5000, "Bloom"));

            for(int a = 0; a < nThread; a++){
                System.out.println(completionService.take().get());
            }
        }
        sc.close();
    }
}
