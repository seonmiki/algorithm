import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
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
		
		for (int i = 1; i <= n; i++) {			
			path[lev] = i;
			run(lev + 1, path);
		}
	}
}
