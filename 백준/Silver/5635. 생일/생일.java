import java.util.*;
import java.io.*;

class Student implements Comparable<Student>{
	String name;
	int day;
	int month;
	int year;
	
	public Student(String name, int day, int month, int year) {
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public int compareTo(Student o) {
		if (this.year != o.year) return o.year - this.year;
		if (this.month != o.year) return o.month - this.month; 
		return o.day - this.day;
	}
	
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		TreeSet<Student> set = new TreeSet<>();
		
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			set.add(new Student(name, day, month, year));
		}
		
		System.out.println(set.first().name);
		System.out.println(set.last().name);
		
	}
}
