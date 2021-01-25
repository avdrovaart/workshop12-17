import java.util.concurrent.ThreadFactory;

public class Loom1 {
    public static void main(String[] args) throws InterruptedException  {
        Runnable printThread = () -> System.out.println(Thread.currentThread());

        ThreadFactory virtualThreadFactory = Thread.ofVirtual().factory();
        ThreadFactory kernelThreadFactory = Thread.ofPlatform().factory();

        Thread virtualThread = virtualThreadFactory.newThread(printThread);
        Thread kernelThread = kernelThreadFactory.newThread(printThread);

        virtualThread.start();
        kernelThread.start();
        virtualThread.join();
        kernelThread.join();
    }
}
