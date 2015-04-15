package collections.add;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * TODO JAVADOCS
 *
 * @author Nosov Alexander
 *         on 11.04.15.
 */
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
public class ArrayListToEndBenchmark {

    private static int ITERATION_SIZE = 1_000_000;

    private static Random rnd = new Random();
    
    @Benchmark
    public List arrayList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ITERATION_SIZE; i++) {
            list.add(rnd.nextInt());
        }
        return list;
    }

}
