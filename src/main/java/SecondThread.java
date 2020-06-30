import javax.swing.plaf.IconUIResource;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SecondThread implements Runnable {
    private final CyclicBarrier cyclicBarrier;
    private final Counter counter;

    public SecondThread(CyclicBarrier cyclicBarrier, Counter counter) {
        this.cyclicBarrier = cyclicBarrier;
        this.counter = counter;
    }

    public void run() {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        while (counter.getValue() < counter.getMaxValue()) {
            counter.increment();
            System.out.println(Thread.currentThread().getName() + " (implements Runnable) incremented value now it's: "
                    + counter.getValue());
        }
        System.out.println(Thread.currentThread().getName() + " (implements Runnable) is finish!");
    }
}
