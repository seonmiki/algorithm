import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Deque<Integer> dodo = new ArrayDeque<>();
		Deque<Integer> suyeon = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			dodo.add(Integer.parseInt(st.nextToken()));
			suyeon.addLast(Integer.parseInt(st.nextToken()));
		}
		
		
		Deque<Integer> dg = new ArrayDeque<>();
		Deque<Integer> sg = new ArrayDeque<>();
//		System.out.println("-----start------- dodo: " + dodo.size() + ", suyeon: " + suyeon.size() + ", dg: " + dg.size() + ", sg: " + sg.size());
		
		for (int i = 0; i < m; i++) {
			if (i % 2 == 0) {
				dg.addLast(dodo.pollLast());
			} else {
				sg.addLast(suyeon.pollLast());
			}
			
			if (dodo.isEmpty() || suyeon.isEmpty()) {
				break ;
			}
			
			if (!dg.isEmpty() && !sg.isEmpty() 
					&& dg.peekLast() + sg.peekLast() == 5) {
				groundBell(suyeon, dg, sg);
//				i++;
//				System.out.println("suyeon bell");
			}
			else if ((!dg.isEmpty() && dg.peekLast() == 5) || (!sg.isEmpty() && sg.peekLast() == 5)) {
				groundBell(dodo, sg, dg);
//				i++;
//				System.out.println("dodo bell");
			}
//			System.out.print("----- " + i + " ------  ");
//			System.out.println("dodo : " + dodo.size() + ", suyeon: " + suyeon.size() + ", dg: " + dg.size() + ", sg: " + sg.size());
		}
		
//		System.out.println("------end----- dodo : " + dodo.size() + ", suyeon: " + suyeon.size() + ", dg: " + dg.size() + ", sg: " + sg.size());
		
		if (dodo.size() == suyeon.size()) {
			System.out.println("dosu");
		} else if (dodo.size() > suyeon.size()) {
			System.out.println("do");
		} else {
			System.out.println("su");
		}
	}
	
	public static void groundBell(Deque<Integer> win, Deque<Integer> g1, Deque<Integer> g2) {
		
		while (!g1.isEmpty()) {
			win.addFirst(g1.pollFirst());
		}
		
		while (!g2.isEmpty()) {
			win.addFirst(g2.pollFirst());
		}
	}
}

