import java.util.Map;
import java.util.HashMap;

public class MemoizedFib {
	public static void main(String [] args) {
		int num = Integer.parseInt(args[0]);
		MemoizedFib fib = new MemoizedFib();
		System.out.println(fib.getFib(num));
	}

	private Map<Integer, Integer> memo = new HashMap<>();

	private int getFib(int num) {
		if (num <=0) {
			return -1;
		}
		if (num == 1 || num == 2) {
			return 1;
		}
		if (memo.containsKey(num)) {
			return memo.get(num);
		}
		memo.put(num, getFib(num-2) + getFib(num-1));
		return memo.get(num);
	}
}


// Time complexity = n
// Space complexity = depends upon size of call stack = n
