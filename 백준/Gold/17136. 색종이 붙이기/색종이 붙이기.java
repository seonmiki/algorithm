import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr = new int[10][10];
	public static int[] paper = {0, 5, 5, 5, 5, 5};
	public static int minCnt = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//값 입력받기
		for (int y = 0; y < 10; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < 10; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		//좌표별로 순회하면서 붙일 수 있는 색종이 탐색하기
		dfs(0, 0, 0);
		
		System.out.println(minCnt == Integer.MAX_VALUE ? -1 : minCnt);
	}
	
	public static void dfs(int y, int x, int cnt) {
		if (x == 10) {
			y++;
			x = 0;
		}
		if (y == 10) {
			minCnt = Math.min(minCnt, cnt);
			return ;				
		}
		while (x < 10 && arr[y][x] == 0) {
			x++;
			if (x == 10) {
				y++;
				x = 0;
			}
			if (y == 10) {
				minCnt = Math.min(minCnt, cnt);
				return ;				
			}
		}
		for (int i = 5; i >= 1; i--) {
			if (isOk(y, x, i) == true) {
//				printArray();
//				System.out.println("y: " + y + ", x: " + x + ", i: " + i);
				attachPaper(y, x, i);
//				printArray();
//				System.out.println("=======================");
				dfs(y, x + 1, cnt + 1);
				detachPaper(y, x, i);
			}
		}
	}
	
	public static void printArray() {
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				System.out.print(arr[y][x] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean isOk(int sy, int sx, int range) {
		if (paper[range] == 0) return false;
		for (int y = 0; y < range; y++) {
			for (int x = 0; x < range; x++) {
				int cy = sy + y;
				int cx = sx + x;
				if (cy < 0 || cy >= 10 || cx < 0 || cx >= 10 
						|| arr[cy][cx] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void attachPaper(int sy, int sx, int range) {
		for (int y = 0; y < range; y++) {
			for (int x = 0; x < range; x++) {
				arr[sy + y][sx + x] = 0;
			}
		}
		paper[range]--;
	}
	
	public static void detachPaper(int sy, int sx, int range) {
		for (int y = 0; y < range; y++) {
			for (int x = 0; x < range; x++) {
				arr[sy + y][sx + x] = 1;
			}
		}
		paper[range]++;
	}
}
