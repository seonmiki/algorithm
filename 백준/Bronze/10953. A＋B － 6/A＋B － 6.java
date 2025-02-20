import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			String input = br.readLine();
			int a = Integer.parseInt(input.charAt(0)+"");
			int b = Integer.parseInt(input.charAt(2)+"");
			sb.append(a + b).append('\n');
		}
		
		System.out.println(sb);
	}
}
