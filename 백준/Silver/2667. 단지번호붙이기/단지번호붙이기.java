import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = {-1, 0, 0, 1};
	static int[] dx = {0, -1, 1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][n];
		for (int y = 0; y < n; y++) {
			String input = br.readLine();
			for (int x = 0; x < n; x++) {
				arr[y][x] = Integer.parseInt(input.charAt(x)+"");
			}
		}
		
		boolean[][] vis = new boolean[n][n];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (arr[y][x] == 1 && vis[y][x] == false) {
					Stack<int[]> stack = new Stack<>();
					stack.add(new int[] {y, x});
					int cnt = 1;
					vis[y][x] = true;
					while (!stack.isEmpty()) {
						int cy = stack.peek()[0];
						int cx = stack.peek()[1];
						stack.pop();
						for (int i = 0; i < 4; i++) {
							int ny = cy + dy[i];
							int nx = cx + dx[i];
							
							if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
							if (arr[ny][nx] == 0 || vis[ny][nx] == true) continue;
							cnt++;
							vis[ny][nx] = true;
							stack.add(new int[] {ny, nx});
						}
					}
					pq.add(cnt);
				}
			}
		}
		
		System.out.println(pq.size());
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}
