import java.util.Map;
import java.util.HashMap;

/*
 * Input - m,n dimension of the grid
 * Number of ways to reach bottom-right from top-left
 * Rule - can only travel dowm and right at a step
 */

public class MemoizedGridTraveller {
	public static void main(String[] args) {
		MemoizedGridTraveller t = new MemoizedGridTraveller();
		System.out.println(t.travel(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}

	private int travel(int m, int n) {
		Map<String, Integer> memo = new HashMap<>();
		return memoizedTravel(m, n, memo);
	}

	private int memoizedTravel(int m, int n, Map<String, Integer> memo) {
		if (m <1 || n<1)
			return 0;
		if (m == 1 || n == 1) {
			return 1;
		}
		// key is in the form of (m + "," + n)
		if (memo.containsKey(m + "," + n)) {
			return memo.get(m + "," + n);
		}
		memo.put(m + "," + n, memoizedTravel(m-1, n, memo) + memoizedTravel(m, n-1, memo));
		memo.put(n + "," + m, memo.get(m + "," + n));

		return memo.get(m + "," + n);
	}
}

// Time complexity = m*n
// Space complexity = m+n
