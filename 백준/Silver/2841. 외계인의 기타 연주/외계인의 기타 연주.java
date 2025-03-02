import java.io.*;
import java.util.*;

public class Main {
	static Stack<Integer>[] list = new Stack[7];
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < 7; i++) {
			list[i] = new Stack<>();
		}
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int fret = Integer.parseInt(st.nextToken());
			if (list[idx].isEmpty()) {
				cnt++;
				list[idx].add(fret);
			} else {
				if (list[idx].peek() == fret) continue;
				else if (list[idx].peek() < fret) {
					cnt++;
					list[idx].add(fret);
				} else { // list[idx].peek() > fret
					while (!list[idx].isEmpty() && list[idx].peek() > fret) {
						list[idx].pop();
						cnt++;
					}
					if (list[idx].isEmpty() || (!list[idx].isEmpty() && list[idx].peek() != fret)) {
						cnt++;
						list[idx].add(fret);
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}
