import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Loom3 {
    public static void main(String[] args) throws InterruptedException {
        ThreadFactory virtualThreadFactory = Thread.ofVirtual().factory();
        ThreadFactory platformThreadFactory = Thread.ofPlatform().factory();

        int numberOfThreads = 100_000;

        List<Thread> virtualList = createThreads(numberOfThreads, virtualThreadFactory, "virtual");
        List<Thread> platformList = createThreads(numberOfThreads, platformThreadFactory, "platform");


        System.out.println("Running platform threads");
        Duration platformDuration = timeIt(platformList);
        System.out.println("Running virtual threads");
        Duration virtualDuration = timeIt(virtualList);
        System.out.println("Platform duration: " + platformDuration);
        System.out.println("Virtual duration: " + virtualDuration);
    }

    private static Duration timeIt(List<Thread> threadList) throws InterruptedException {
        Instant start = Instant.now();
        threadList.forEach(Thread::start);
        for (Thread thread : threadList) {
            thread.join();
        }
        return Duration.between(start, Instant.now());

    }

    private static List<Thread> createThreads(int count, ThreadFactory factory, String name) {
        return IntStream
                .rangeClosed(1 ,count)
                .boxed()
                .map(i -> createThread(factory, () -> slaap(i, name)))
                .collect(Collectors.toList());
    }

    private static Thread createThread(ThreadFactory factory, Runnable runner) {
        return factory.newThread(runner);
    }

    private static void slaap(int i, String name) {
        try {
            //System.out.println("Start slaap nr: " + i + " for " + name);
            Thread.sleep(1000);
            //System.out.println("Eind slaap nr: " + i + " for " + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
