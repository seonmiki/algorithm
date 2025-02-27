import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			Map<String, List<String>> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String item = st.nextToken();
				String category = st.nextToken();
				if (!map.containsKey(category)) {
					map.put(category, new ArrayList<>());
				}
				map.get(category).add(item);
			}
			
			int ret = 1;
			for (String category : map.keySet()) {
				ret *= (map.get(category).size() + 1);
			}
			sb.append(ret - 1).append("\n");
		}
		System.out.println(sb);
	}
}
