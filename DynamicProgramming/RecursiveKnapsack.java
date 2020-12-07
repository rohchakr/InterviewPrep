import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class RecursiveKnapsack {
	public static void main(String [] args) {
		RecursiveKnapsack r = new RecursiveKnapsack();
		System.out.println(r.solve(7, Arrays.asList(2, 3)));
		System.out.println(r.solve(7, Arrays.asList(5, 3, 4, 7)));
		System.out.println(r.solve(7, Arrays.asList(2, 4)));
		System.out.println(r.solve(8, Arrays.asList(2, 3, 5)));
	}

	private boolean solve(int sum, List<Integer> arrList) {
		if (sum == 0) {
			return true;
		}
		if (sum < 0) {
			return false;
		}
		for (int i : arrList) {
			if (solve(sum - i, arrList)) {
				return true;
			}
			// else continue;
		}
		// return false outside loop to ensure all elements have been traversed before returning false
		return false;
	}
}

// Time complexity = Arr size ^ sum
// Space complexity = sum
