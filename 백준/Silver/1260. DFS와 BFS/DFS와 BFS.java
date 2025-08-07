import java.io.*;
import java.util.*;

public class Main {
	static int N, M, V;
	static List<Integer>[] arr;
	static boolean[] vis;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from].add(to);
			arr[to].add(from);
		}
		
		StringBuilder sb = new StringBuilder();
		
		// 정점 번호가 작은 것부터 방문하려면 정렬 필요
		for (int i = 1; i <= N; i++) {
		    Collections.sort(arr[i]);
		}

		
		vis = new boolean[N + 1];
		Arrays.fill(vis, false);
		
		//dfs
		dfs(V, sb);
		
		sb.append("\n");
		
		Arrays.fill(vis, false);
		vis[V] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur).append(" ");
			for (int nxt : arr[cur]) {
				if (vis[nxt]) continue;
				vis[nxt]= true;
				queue.add(nxt);
			}
		}
		
		
		System.out.println(sb);
		
	}
	
	static void dfs(int cur, StringBuilder sb) {
		vis[cur] = true;
		sb.append(cur).append(" ");
		for (int nxt : arr[cur]) {
			if (!vis[nxt]) {
				dfs(nxt, sb);
			}
		}
	}
}
