import java.util.ArrayList;

public class Fibonacci {
    ArrayList<Integer> seq = new ArrayList<Integer>();
    int i;

    public Fibonacci (int i) {
        this.i = i;
        seq.add(1);
        seq.add(1);
    }

    public int fib (int iterations) {
        int length = seq.size();
        seq.add(seq.get(length-2) + seq.get(length-1));

        if (seq.size() == i) {
            return seq.get(seq.size()-1);
        } else {
            return fib(iterations - 1);
        }
    }

    public void printSeq () {
        System.out.println("The sequence is: " + seq);
    }

}
