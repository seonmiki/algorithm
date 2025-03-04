import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if (!list.contains(cur)) {
				pq.add(cur);
				list.add(cur);
			}
		}
		
		while (!pq.isEmpty()) {
			System.out.print(pq.poll() + " ");
		}
	}
}
