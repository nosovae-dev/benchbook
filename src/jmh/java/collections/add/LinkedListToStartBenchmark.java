package collections.add;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.LinkedList;
import java.util.List;

/**
 * TODO JAVADOCS
 *
 * @author Nosov Alexander
 *         on 11.04.15.
 */
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
public class LinkedListToStartBenchmark {
	@Benchmark
	public List linkedList() {
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < PackageUtil.ITERATION_SIZE; i++) {
			list.add(0, 200);
		}
		return list;
	}
}
