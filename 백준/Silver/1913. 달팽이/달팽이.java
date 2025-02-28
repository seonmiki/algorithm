import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][n];
		int ty = -1, tx = -1;
		
		int k = n * n;
		int size = n;
		int y = -1;
		int x = 0;
		int dir = 1;
		while (k > 0) {
			for (int i = 0; i < size; i++) {
				y += dir;
				arr[y][x] = k--;
			}
			size--;
			
			for (int i = 0; i < size; i++) {
				x += dir;
				arr[y][x] = k--;
			}
			dir *= -1;
		}
		
		for (int yy = 0; yy < n; yy++) {
			for (int xx = 0; xx < n; xx++) {
				System.out.print(arr[yy][xx] + " ");
				if (arr[yy][xx] == target) {
					ty = yy + 1;
					tx = xx + 1;
				}
			}
			System.out.println();
		}
		System.out.println(ty + " " + tx);
		
	}
}
