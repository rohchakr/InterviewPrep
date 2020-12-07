import java.util.Map;
import java.util.HashMap;

public class MemoizedFib {
	public static void main(String [] args) {
		int num = Integer.parseInt(args[0]);
		MemoizedFib fib = new MemoizedFib();
		System.out.println(fib.getFib(num));
	}

	private int getFib(int num) {
		Map<Integer, Integer> memo = new HashMap<>();
		return getMemoizedFib(num, memo);
	}

	private int getMemoizedFib(int num, Map<Integer, Integer> memo) {
		if (num <=0) {
			return -1;
		}
		if (num == 1 || num == 2) {
			return 1;
		}
		if (memo.containsKey(num)) {
			return memo.get(num);
		}
		memo.put(num, getMemoizedFib(num-2, memo) + getMemoizedFib(num-1, memo));
		return memo.get(num);
	}
}


// Time complexity = n
// Space complexity = depends upon size of call stack = n
