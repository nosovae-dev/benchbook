package collections.toarray;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(3)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
/**
 * @author Nosov Alexander
 */
public class ToArrayBenchmark {

	List<Integer> list;

	@Param({"1", "100", "10000"})
	private int size;

	@Setup
	public void setup() throws Throwable {
		list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			list.add(i);
		}
	}

	@Benchmark
	public ArrayList<Integer> manual_copy() {
		final ArrayList<Integer> newList = new ArrayList<>(list.size());
		for (Integer integer : list) {
			newList.add(integer);
		}
		return newList;
	}
	
	
	

	@Benchmark
	public ArrayList<Integer> simple_copy() {
		return new ArrayList<>(list);
	}

	@Benchmark
	public Object[] simple_toArray() {
		return list.toArray();
	}

	@Benchmark
	public Integer[] zero_sized_array() {
		return list.toArray(new Integer[0]);
	}

	@Benchmark
	public Integer[] sized_array_from_list() {
		return list.toArray(new Integer[list.size()]);
	}

	@Benchmark
	public Integer[] sized_array_fixed_size() {
		return list.toArray(new Integer[size]);
	}
}