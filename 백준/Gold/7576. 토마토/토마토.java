import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static int N;
	static boolean[][] check;
	static int[] dix = {-1,1,0,0};
	static int[] diy = {0,0,1,-1};
	static Queue<int[]> qu = new LinkedList<>();
	static int max=0;
	public static void bfs(int[][] a) {
	       	
		 while(!qu.isEmpty()) {
			 int[] temp = qu.poll();
			 checking(a,temp[0],temp[1]);
			 
		 }
	}
	
	public static void checking(int[][] a,int x,int y){
	
		 for(int i=0;i<4;i++) {
			 int X= x+dix[i];
			 int Y= y+diy[i];
			 if(0<=X&&X<N&&0<=Y&&Y<M) {
				 if(a[X][Y]==0&&!check[X][Y]) {
					 a[X][Y]=a[x][y]+1;
					 check[X][Y]=true;
					 qu.offer(new int[] {X,Y});
				 }
			 }
		 }
	}
		public static void main(String args[]) throws IOException{
	
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
     StringTokenizer st = new StringTokenizer(br.readLine());
     
     M=Integer.parseInt(st.nextToken());
     N=Integer.parseInt(st.nextToken());
    
     int[][] tomatobox = new int[N][M];
     int zerocount=0;
     for(int i=0;i<N;i++) {
    	 st = new StringTokenizer(br.readLine());
    	 for(int k=0;k<M;k++) {
    		 tomatobox[i][k]=Integer.parseInt(st.nextToken());
    		 if(tomatobox[i][k]==1) {
    			qu.offer(new int[] {i,k});
    		 }else if(tomatobox[i][k]==0)
    			 zerocount++;
    	 }
     }
    if(zerocount==0) {
    	System.out.println(0);
    	return;
    }
    	
    check=new boolean[N][M];
    bfs(tomatobox);
    
    for(int i=0;i<N;i++) {
   	 for(int k=0;k<M;k++) {
   		 if(tomatobox[i][k]==0) {
   			System.out.println(-1);
   			return;
   		 }
   		 max=Math.max(tomatobox[i][k], max);
   	 }
    }
    System.out.println(max-1);
  }
}
