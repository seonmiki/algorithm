import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		long[] dp = new long[100];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i < 100; i++) {
			dp[i] = dp[i - 3] + dp[i - 2];
		}
		
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n - 1]).append("\n");
		}
		System.out.println(sb);
	}
}
