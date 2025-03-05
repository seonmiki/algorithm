import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			String input = sc.next();
			int last = Integer.parseInt(input.charAt(input.length() - 1)+"");
			if (last % 2 == 0) System.out.println("even");
			else System.out.println("odd");
		}
	}
}
