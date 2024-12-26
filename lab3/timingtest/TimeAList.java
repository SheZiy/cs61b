package timingtest;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        for (int n = 1000; n <=128000; n = n * 2) {
            Ns.addLast(n);
        }
        AList<Integer> testAList;
        int opcount;
        int size;
        Stopwatch sw;
        for (int i = 0; i < Ns.size(); i += 1) {
            testAList = new AList<>();
            size = Ns.get(i);
            opcount = 0;
            sw = new Stopwatch();
            for (int s = 0; s < size; s++) {
                testAList.addLast(0);
                opcount++;
            }
            times.addLast(sw.elapsedTime());
            opCounts.addLast(opcount);
        }
        printTimingTable(Ns, times, opCounts);
    }
}
