import java.util.*;
import java.io.*;

public class Main {
	static int n, k;
	static char[] arr;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new char[k];
		for (int i = 0; i < k; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		
		sb = new StringBuilder();
		run(0, "");
		
		System.out.println(sb);
	}
	
	static void run(int lev, String ret) {
		if (lev == n) {
			if (isOk(ret)) sb.append(ret + "\n");
			return ;
		}
		
		for (int i = 0; i < k; i++) {
			if (ret.contains(arr[i]+"")) continue;
			if (lev > 0 && ret.charAt(ret.length() - 1) > arr[i]) continue;
			run(lev + 1, ret + arr[i]);
		}
	}
	
	static boolean isOk(String ret) {
		int aeiou = 0;
		for (int i = 0; i < n; i++) {
			if ("aeiou".contains(ret.charAt(i)+""))
				aeiou++;
		}
		return aeiou > 0 && aeiou <= n - 2 ? true : false;
	}
}
