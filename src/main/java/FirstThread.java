import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class FirstThread extends Thread {
    private final CyclicBarrier cyclicBarrier;
    private final Counter counter;

    public FirstThread(CyclicBarrier cyclicBarrier, Counter counter) {
        this.cyclicBarrier = cyclicBarrier;
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        while (counter.getValue() < counter.getMaxValue()) {
            counter.increment();
            System.out.println(Thread.currentThread().getName()
                    + " (extends Thread) incremented value now it's: " + counter.getValue());
        }
        System.out.println(Thread.currentThread().getName() + " (extends Thread) is finish!");
    }
}
