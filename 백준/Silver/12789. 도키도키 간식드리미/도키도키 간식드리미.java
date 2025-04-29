import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int get = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num == get + 1) {
				get++;
			} else {
				while (!stack.isEmpty() && stack.peek() == get + 1) {
					stack.pop();
					get++;
				}
				stack.add(num);
			}
//			System.out.println("num: " + num + Arrays.toString(stack.toArray()));
		}
		
		while (!stack.isEmpty() && stack.peek() == get + 1) {
			stack.pop();
			get++;
		}
		
		if (stack.isEmpty()) System.out.println("Nice");
		else System.out.println("Sad");
	}
}
