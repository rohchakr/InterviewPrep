/*
 * Input - m,n dimension of the grid
 * Number of ways to reach bottom-right from top-left
 * Rule - can only travel dowm and right at a step
 */

public class RecursiveGridTraveller {
	public static void main(String[] args) {
		RecursiveGridTraveller t = new RecursiveGridTraveller();
		System.out.println(t.travel(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}

	private int travel(int m, int n) {
		if (m <1 || n<1)
			return 0;
		if (m == 1 || n == 1) {
			return 1;
		}
		return travel(m-1, n) + travel(m, n-1);
	}
}

// Time complexity = 2^(m+n)
// Space complexity = m+n
