public class RecursiveFib {
	public static void main(String [] args) {
		int num = Integer.parseInt(args[0]);
		RecursiveFib fib = new RecursiveFib();
		System.out.println(fib.getFib(num));
	}

	private int getFib(int num) {
		if (num <=0) {
			return -1;
		}
		if (num == 1 || num == 2) {
			return 1;
		}
		return getFib(num-2) + getFib(num-1);
	}
}


// Time complexity = 2^n
// Space complexity = depends upon size of call stack = n
