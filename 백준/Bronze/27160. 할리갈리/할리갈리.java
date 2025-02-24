import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<>();
		map.put("STRAWBERRY", 0);
		map.put("BANANA", 0);
		map.put("LIME", 0);
		map.put("PLUM", 0);
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String key = st.nextToken();
			int value = Integer.parseInt(st.nextToken());
			
			map.replace(key, map.get(key) + value);
		}
		
		for (String key : map.keySet()) {
			if (map.get(key) == 5) {
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}
}
