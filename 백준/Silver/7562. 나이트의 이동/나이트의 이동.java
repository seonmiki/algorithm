import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int cy, cx, ty, tx;
	static int arr[][];
	static boolean vis[][];
	
	static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			cy = Integer.parseInt(st.nextToken());
			cx = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			ty = Integer.parseInt(st.nextToken());
			tx = Integer.parseInt(st.nextToken());
			
			arr = new int[n][n];
			vis = new boolean[n][n];
			
			sb.append(run() +"\n");
		}
		System.out.println(sb);
	}
	
	static int run() {
		if (cy == ty && cx == tx) return 0;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {cy, cx, 0});
		vis[cy][cx] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int y = cur[0];
			int x = cur[1];
			int moves = cur[2];
			
			for (int i = 0; i < 8; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if (ny < 0 || ny >= n || nx < 0 || nx >= n || vis[ny][nx]) continue;
				
				if (ny == ty && nx == tx) return moves + 1;
				
				vis[ny][nx] = true;
				queue.offer(new int[] {ny, nx, moves + 1});
			}
		}
		
		return -1;
	}
}
