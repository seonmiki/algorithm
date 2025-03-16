import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[] arr;
	static int[] cnt;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		
		arr = new int[n];
		cnt = new int[n];
		int i = 0;
		for (int key : map.keySet()) {
			arr[i] = key;
			cnt[i] = map.get(key);
			i++;
		}

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
		
		for (int i = 0; i < n; i++) {
			if (cnt[i] == 0) continue ;

			path[lev] = arr[i];
			cnt[i]--;
			run(lev + 1, path);
			cnt[i]++;
		}
	}
}
