import java.util.*;
import java.io.*;

public class Main {
	static int width, height, k;
	static int[][] arr;
	static boolean[][] vis;
	
	static int[] dy = {-1, 0, 0, 1};
	static int[] dx = {0, -1, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new int[height][width];
		vis = new boolean[height][width];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int ly = Integer.parseInt(st.nextToken());
			int lx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			
			for (int y = ly; y < ry; y++) {
				for (int x = lx; x < rx; x++) {
					arr[y][x] = 1;
				}
			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (arr[y][x] == 0 && vis[y][x] == false) {
					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[] {y, x});
					vis[y][x] = true;
					int cnt = 1;
					while (!queue.isEmpty()) {
						int cy = queue.peek()[0];
						int cx = queue.peek()[1];
						queue.poll();
						
						for (int i = 0; i < 4; i++) {
							int ny = cy + dy[i];
							int nx = cx + dx[i];
							
							if (ny < 0 || ny >= height || nx < 0 || nx >= width) continue ;
							if (arr[ny][nx] == 1 || vis[ny][nx] == true) continue ;
							
							queue.add(new int[] {ny, nx});
							vis[ny][nx] = true;
							cnt++;
						}
					}
					pq.add(cnt);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(pq.size() + "\n");
		while (!pq.isEmpty()) {
			sb.append(pq.poll() + " ");
		}
		
		System.out.println(sb);
	}
}
