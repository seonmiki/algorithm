import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		
		int cutting = pq.peek();
		int cnt = 0;
		int get = 0;
		while (cutting >= 0) {
			if (!pq.isEmpty() && pq.peek() > cutting) {
				while (!pq.isEmpty() && pq.peek() > cutting) {
					pq.poll();
					cnt += 1;
				}
			}
			get += cnt * 1;
			if (get >= m) {
				System.out.println(cutting);
				return ;
			}
			cutting--;
		}
	}
}
