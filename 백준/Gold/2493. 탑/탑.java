import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Stack<int[]> stack = new Stack<>(); //[0] num [1] idx
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			int hit = 0;
			while (!stack.isEmpty()) {
//				System.out.println("i: " + i + ", num: " + num);
				if (num < stack.peek()[0]) {
					hit = stack.peek()[1];
					break ;
				} else {
					stack.pop();
				}
			}
			stack.add(new int[] {num, i});
			sb.append(hit).append(" ");
		}
		
		System.out.println(sb);
	}
}
