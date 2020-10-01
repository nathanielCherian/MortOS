import java.util.ArrayList;

public class Fibonacci {
    ArrayList<Integer> seq = new ArrayList<Integer>();
    int i;

    public Fibonacci (int i) {
        seq.add(1);
        seq.add(1);
        this.i = i;
    }

    public int fib (int iterations) {
        int length = seq.size();
        seq.add(seq.get(length-2) + seq.get(length-1));

        if (seq.size() == iterations) {
            return seq.get(i);
        } else {
            return fib(iterations - 1);
        }
    }


}
