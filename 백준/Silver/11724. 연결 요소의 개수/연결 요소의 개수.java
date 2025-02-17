import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static List<List<Integer>> graph = new ArrayList<>();
	static int[] vis;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		vis = new int[n + 1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for (int i = 1; i <= n; i++) {
			if (vis[i] == 1) continue ;
			cnt++;
			Stack<Integer> stack = new Stack<>();
			stack.add(i);
			vis[i] = 1;
			while(!stack.isEmpty()) {
				int cur = stack.pop();
				for (int nxt : graph.get(cur)) {
					if (vis[nxt] == 1) continue ;
					stack.add(nxt);
					vis[nxt] = 1;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
