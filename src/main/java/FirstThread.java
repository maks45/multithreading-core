import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class FirstThread extends Thread {
    private final CyclicBarrier cyclicBarrier;
    private final int[] value;

    public FirstThread(CyclicBarrier cyclicBarrier, int[] value) {
        this.cyclicBarrier = cyclicBarrier;
        this.value = value;
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        for (; value[0] < Main.END; value[0]++) {
            System.out.println(Thread.currentThread().getName()
                    + " (extends Thread) incremented value now it's: " + value[0]);
        }
        System.out.println(Thread.currentThread().getName() + " (extends Thread) is finish!");
    }
}
