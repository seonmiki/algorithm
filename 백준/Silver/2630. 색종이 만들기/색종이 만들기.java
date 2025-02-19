import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int whiteCnt, blueCnt = 0;
	static int white = 0;
	static int blue = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < n; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, n);
		
		System.out.println(whiteCnt + "\n" + blueCnt);
	}
	
	public static void dfs(int sy, int sx, int n) {
		int cur = arr[sy][sx];
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (arr[sy + y][sx + x] != cur) {
					int size = n / 2;
					dfs(sy, sx, size);
					dfs(sy, sx + size, size);
					dfs(sy + size, sx, size);
					dfs(sy + size, sx + size, size);
					return ;
				}
			}
		}
		if (cur == white) whiteCnt++;
		else blueCnt++;
	}
}
