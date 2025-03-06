import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long ret = 1;
		for (int i = 1; i <= n; i++) {
			ret *= i;
		}
		
		System.out.println(ret);
	}
}
