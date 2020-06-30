import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        Counter counter = new Counter(0, 100);
        Thread firstThread = new FirstThread(barrier, counter);
        Thread secondThread = new Thread(new SecondThread(barrier, counter));
        firstThread.start();
        secondThread.start();
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
