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

	private Map<String, Integer> memo = new HashMap<>();

	private int travel(int m, int n) {
		if (m <1 || n<1)
			return 0;
		if (m == 1 || n == 1) {
			return 1;
		}
		// key is in the form of (m + "," + n)
		if (memo.containsKey(m + "," + n)) {
			return memo.get(m + "," + n);
		}
		memo.put(m + "," + n, travel(m-1, n) + travel(m, n-1));
		memo.put(n + "," + m, memo.get(m + "," + n));

		return memo.get(m + "," + n);
	}
}

// Time complexity = m*n
// Space complexity = m+n
