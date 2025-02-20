import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			
			PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
			List<List<Integer>> list = new ArrayList<>();
			for (int i = 0; i <= 9; i++) {
				list.add(new ArrayList<>());
			}
			
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int value = Integer.parseInt(st.nextToken());
				queue.add(value);
				list.get(value).add(i);
			}
			
			int i = 1;
			int idx = 0;
			while (i <= n) {
				int cur = queue.peek();
				int cnt = 0;
				boolean flag = false;
				for (int nxt : list.get(cur)) {
					if (nxt < idx) {
						cnt++;
						continue;
					}
					if (nxt == target) {
//						System.out.println("nxt: " + nxt);
						System.out.println(i);
						flag = true;
						break;
					} else {
						idx = nxt;
						queue.poll();
						i++;
					}
				}
				for (int j = 0; j < cnt; j++) {
					if (list.get(cur).get(j) == target) {
//						System.out.println("nxt: " + list.get(cur).get(j));
//						System.out.println("idx: " + idx);
						System.out.println(i);
						flag = true;
						break;
					}
					idx = list.get(cur).get(j);
					queue.poll();
					i++;
				}
				if (flag) break;
			}
		}
	}
}
