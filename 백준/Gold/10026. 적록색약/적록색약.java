import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static char[][] arr;
	static boolean[][] vis;
	static int cnt1;
	static int cnt2;
	static int[] dy = {-1, 0, 0, 1};
	static int[] dx = {0, -1, 1, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		vis = new boolean[n][n];
		for (int y = 0; y < n; y++) {
			String input = br.readLine();
			for (int x = 0; x < n; x++) {
				arr[y][x] = input.charAt(x);
			}
		}
		
		cnt1 = 0;
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (vis[y][x] == false) {
					cnt1++;
					vis[y][x] = true;
					run1(y, x, arr[y][x]);
				}
			}
		}
	
		for (int y = 0; y < n; y++) {
			Arrays.fill(vis[y], false);
		}
		
		cnt2 = 0;
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (vis[y][x] == false) {
					cnt2++;
					vis[y][x] = true;
					String str;
					if (arr[y][x] == 'R' || arr[y][x] == 'G')
						str = "RG";
					else
						str = arr[y][x]+"";
					run2(y, x, str);
				}
			}
		}
		
		System.out.println(cnt1 + " " + cnt2);
	}
	
	public static void run1(int sy, int sx, char c) {
		for (int i = 0; i < 4; i++) {
			int ny = sy + dy[i];
			int nx = sx + dx[i];
			
			if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
			if (arr[ny][nx] != c || vis[ny][nx] == true) continue;
			vis[ny][nx] = true;
			run1(ny, nx, c);
		}
		
	}
	
	public static void run2(int sy, int sx, String str) {
		for (int i = 0; i < 4; i++) {
			int ny = sy + dy[i];
			int nx = sx + dx[i];
			
			if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
			if (str.contains(arr[ny][nx]+"") == false || vis[ny][nx] == true) continue;
			vis[ny][nx] = true;
			run2(ny, nx, str);
		}
		
	}
}
