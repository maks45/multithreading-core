import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static final int END = 100;
    private static volatile int[] value = {0};
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        Thread firstThread = new FirstThread(barrier, value);
        Thread secondThread = new Thread(new SecondThread(barrier, value));
        firstThread.start();
        secondThread.start();
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
