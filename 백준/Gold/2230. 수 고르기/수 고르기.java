import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int limit = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = 1;
		int minRet = Integer.MAX_VALUE;
		while (start < n - 1) {
			while (end < n && arr[end] - arr[start] < limit) end++;
			if (end < n) minRet = Math.min(minRet, arr[end] - arr[start]);
			start++;
		}
		
		System.out.println(minRet);
	}
}
