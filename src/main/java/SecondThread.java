import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SecondThread implements Runnable {
    private final CyclicBarrier cyclicBarrier;
    private final int[] value;

    public SecondThread(CyclicBarrier cyclicBarrier, int[] value) {
        this.cyclicBarrier = cyclicBarrier;
        this.value = value;
    }

    public void run() {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        for(; value[0] < Main.END; value[0]++){
            System.out.println(Thread.currentThread().getName()+ " (implements Runnable) incremented value now it's: " + value[0]);
        }
        System.out.println(Thread.currentThread().getName()+ " (implements Runnable) is finish!");
    }
}
