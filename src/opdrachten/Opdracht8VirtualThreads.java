package opdrachten;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

// java --source 17 --enable-preview Opdracht8VirtualThreads.java
// TODO: Convert to Virtual threads
public class Opdracht8VirtualThreads {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        virtualthreads1();
        virtualthreads2();
        virtualthreads3();
    }

    private static void virtualthreads1() {
        // Een thread via een constructor
        Thread thread = new Thread(() -> System.out.println("Thread1 is virtual: " + Thread.currentThread().isVirtual()));
        thread.start();
    }

    private static void virtualthreads2() {
        // Een Thread via een builder, die niet direct is gestart
        Thread t = Thread.ofPlatform()
                .unstarted(() -> System.out.println("Thread2 is virtual: " + Thread.currentThread().isVirtual()));
        t.start();
    }

    private static void virtualthreads3() throws ExecutionException, InterruptedException {
        ThreadFactory tf = Thread.ofPlatform().factory();
        ExecutorService e = Executors.newThreadExecutor(tf);
        Future<String> f = e.submit(() -> "Thread3 is virtual: " + Thread.currentThread().isVirtual());
        System.out.println(f.get());
    }

}

