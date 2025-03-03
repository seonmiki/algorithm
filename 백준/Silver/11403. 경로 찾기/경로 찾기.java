import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		StringTokenizer st;
		for (int y = 0; y < n; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < n; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					if (arr[y][i] == 1 && arr[i][x] == 1) {
						arr[y][x] = 1;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				sb.append(arr[y][x] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
