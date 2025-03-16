import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[] arr;
	static boolean[] vis;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		sb = new StringBuilder();
		vis = new boolean[n];
		run(0, new int[m]);
		
		System.out.println(sb);
	}
	
	static void run(int lev, int[] path) {
		if (lev == m) {
			for (int i = 0; i < m; i++) {
				sb.append(path[i] + " ");
			}
			sb.append("\n");
			return ;
		}
		
		for (int i = 0; i < n; i++) {
			if (vis[i]) continue ;
			if (lev > 0 && path[lev - 1] > arr[i]) continue;
			
			path[lev] = arr[i];
			vis[i] = true;
			run(lev + 1, path);
			vis[i] = false;
		}
	}
}
