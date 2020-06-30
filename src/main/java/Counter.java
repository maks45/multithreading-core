import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Counter {
    private int value;
    private final int maxValue;

    public synchronized void increment(){
        value++;
    }
}
