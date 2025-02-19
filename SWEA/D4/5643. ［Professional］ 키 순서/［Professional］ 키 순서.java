import java.io.*;
import java.util.*;

public class Solution {
	static int n, m, cnt;
	static List<List<Integer>> tallGraph;
	static List<List<Integer>> smallGraph;
	static boolean[] vis;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			cnt = 0;
			tallGraph = new ArrayList<>();
			smallGraph = new ArrayList<>();
			vis = new boolean[n + 1];
			
			for (int i = 0; i <= n; i++) {
				tallGraph.add(new ArrayList<>());
				smallGraph.add(new ArrayList<>());
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				tallGraph.get(a).add(b);
				smallGraph.get(b).add(a);
			}
			
			for (int i = 1; i <= n; i++) {
				int tallCnt = 0;
				Stack<Integer> stack = new Stack<>();
				stack.add(i);
				while (!stack.isEmpty()) {
					int cur = stack.pop();
					for (int nxt : tallGraph.get(cur)) {
						if (vis[nxt] == true) continue ;
						tallCnt++;
						vis[nxt] = true;
						stack.add(nxt);
					}
				}
				
				int smallCnt = 0;
				Arrays.fill(vis, false);
				stack.add(i);
				while (!stack.isEmpty()) {
					int cur = stack.pop();
					for (int nxt : smallGraph.get(cur)) {
						if (vis[nxt] == true) continue ;
						smallCnt++;
						vis[nxt] = true;
						stack.add(nxt);
					}
				}
				
				if (tallCnt + smallCnt == n - 1) cnt++;
			}
			
			sb.append("#" + tc + " " + cnt + "\n");
		}
		
		System.out.println(sb);
	}
}