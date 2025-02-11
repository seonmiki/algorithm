import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
      static int N;
	  static boolean[][] check;
	  static boolean[][] RGcheck;
	  static int[] dix= {1,-1,0,0};
	  static int[] diy= {0,0,1,-1};
	  static int count=0;
	  static int RGcheckcount=0;
	  public static void dfs(char[][] a,int x,int y) {
		  if(!check[x][y]) {
			  count++;
			  check[x][y]=true;
			
		  for(int i=0;i<4;i++) {
			  int X=x+dix[i];
			  int Y=y+diy[i];
			  if(0<=X&&X<N&&0<=Y&&Y<N) {
			     if(a[x][y]==a[X][Y]&&!check[X][Y]) {
						  dfs(a,X,Y);
					 }
			  }
		   	}	
		 }
	   }

	 public static void checkRG(char[][] a,int x,int y) {
		 if(!RGcheck[x][y]) {
			 RGcheckcount++;
			 RGcheck[x][y]=true;
		  for(int i=0;i<4;i++) {
			  int X=x+dix[i];
			  int Y=y+diy[i];
			  if(0<=X&&X<N&&0<=Y&&Y<N) {
				   if(a[X][Y]==a[x][y]&&a[x][y]=='B') {
					   checkRG(a,X,Y);
					 }else if((a[x][y]=='R'||a[x][y]=='G')&&(a[X][Y]=='R'||a[X][Y]=='G')) {
						     checkRG(a,X,Y);
				   }
				     
			 }
		  	}  
		  }
		 
	 }
	  
	 public static void main(String args[]) throws IOException{
	
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     N=Integer.parseInt(br.readLine());
     char[][] color = new char[N][N];
     for(int i=0;i<N;i++) {
    	 String str= br.readLine();
    	 for(int k=0;k<N;k++) {
    		 color[i][k]=str.charAt(k);
    	 }
     }
     check=new boolean[N][N];
     RGcheck=new boolean[N][N];
     int normalcount=0;
     int abnormalcount=0;
     for(int i=0;i<N;i++) {
    	 for(int k=0;k<N;k++) {
    		 dfs(color,i,k);
    		 if(count>0) {
    			 normalcount++;
    			 count=0;
    		 }
    		 checkRG(color,i,k);
    		 if(RGcheckcount>0) {
    			 abnormalcount++;
    			 RGcheckcount=0;
    		 }
    	 }
     }
     
    System.out.println(normalcount+" "+abnormalcount);
  }
}