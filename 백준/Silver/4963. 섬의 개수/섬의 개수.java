import java.util.*;
import java.io.*;

public class Main {
	static int w, h;
	static int[][] map;
	static boolean[][] vis;
	
	static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) break;
			
			map = new int[h][w];
			for (int y = 0; y < h; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < w; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			vis = new boolean[h][w];
			for (int y = 0; y < h; y++) {
				for (int x = 0; x < w; x++) {
					if (vis[y][x] || map[y][x] == 0) continue;
					
					cnt++;
					Stack<int[]> stack = new Stack<>();
					stack.add(new int[] {y, x});
					vis[y][x] = true;
					
					while (!stack.isEmpty()) {
						int[] cur = stack.pop();
						int cy = cur[0];
						int cx = cur[1];
						
						for (int i = 0; i < 8; i++) {
							int ny = cy + dy[i];
							int nx = cx + dx[i];
							
							if (ny < 0 || ny >= h || nx < 0 || nx >= w || vis[ny][nx]) continue;
							if (map[ny][nx] == 0) continue;
							
							stack.add(new int[] {ny, nx});
							vis[ny][nx] = true;
						}
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
		
	}
}
