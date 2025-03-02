import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		int i = 0;
		Stack<Character> stack = new Stack<>();
		while (i < input.length()) {
			if (input.charAt(i) == '<') {
				stackPop(stack, sb);
				while (input.charAt(i) != '>') {
					sb.append(input.charAt(i));
					i++;
				}
				sb.append('>');
			}
			else if (input.charAt(i) == ' ') {
				stackPop(stack, sb);
				sb.append(' ');
			}
			else {
				stack.add(input.charAt(i));
			}
			i++;
		}
		stackPop(stack, sb);
		System.out.println(sb);
	}
	
	public static void stackPop(Stack<Character> stack, StringBuilder sb) {
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
	}
}
