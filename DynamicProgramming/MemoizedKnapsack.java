import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class MemoizedKnapsack {
	public static void main(String [] args) {
		MemoizedKnapsack r = new MemoizedKnapsack();
		System.out.println(r.solve(7, Arrays.asList(2, 3)));
		System.out.println(r.solve(7, Arrays.asList(5, 3, 4, 7)));
		System.out.println(r.solve(7, Arrays.asList(2, 4)));
		System.out.println(r.solve(8, Arrays.asList(2, 3, 5)));
	}

	/*
	 * Returns true if required sum is possible with any combinations of the given array
	 * Each numbers in the array can be used as many times as needed
	 * Returns false otherwise
	 */
	private boolean solve(int sum, List<Integer> arrList) {
		Map<Integer, Boolean> memo = new HashMap<>();
		return solveWithMemo(sum, arrList, memo);
	}

	private boolean solveWithMemo(int sum, List<Integer> arrList, Map<Integer, Boolean> memo) {
		if (sum == 0) {
			return true;
		}
		if (sum < 0) {
			return false;
		}
		if (memo.containsKey(sum)) {
			return memo.get(sum);
		}
		for (int i : arrList) {
			if (solve(sum - i, arrList)) {
				memo.put(sum, true);
				return true;
			}
			// else continue;
		}
		// return false outside loop to ensure all elements have been traversed before returning false
		memo.put(sum, false);
		return false;
	}
}

// Time complexity = O(Arr size * sum)
// Space complexity = O(sum)
