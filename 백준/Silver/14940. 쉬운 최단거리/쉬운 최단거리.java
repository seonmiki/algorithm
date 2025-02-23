import java.io.*;
import java.util.*;

public class Main {
	static int[] dy = {-1, 0, 0, 1};
	static int[] dx = {0, -1, 1, 0};
	static int[][] arr, dist;
	static int n, m;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		dist = new int[n][m];
		Queue<int[]> queue = new LinkedList<>();
		
		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < m; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				if (arr[y][x] == 2) {
					queue.add(new int[] {y, x});
					dist[y][x] = 0;
				} else {
					dist[y][x] = -1;
				}
			}
		}
		
		bfs(queue);
		
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < m; x++) {
				if (arr[y][x] == 0) {
					sb.append("0 ");
				} else {
					sb.append(dist[y][x] + " ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static public void bfs(Queue<int[]> queue) {
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int sy = cur[0];
			int sx = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int ny = sy + dy[i];
				int nx = sx + dx[i];
				
				if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
				if (arr[ny][nx] == 0 || dist[ny][nx] != -1) continue;
				
				dist[ny][nx] = dist[sy][sx] + 1;
				queue.add(new int[] {ny, nx});
			}
		}
	}
}
