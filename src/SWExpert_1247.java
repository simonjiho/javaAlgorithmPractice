import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWExpert_1247 {
	
	static int N;
	static int[] num;
	static int numCnt;
	static int swCnt;
	static int maxVal;
	static boolean[][] visited;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			String[] input = br.readLine().split(" ");			
			
			String num_str = input[0];
			swCnt = Integer.parseInt(input[1]);
			numCnt =  num_str.length();
			maxVal = Integer.MIN_VALUE;
			num = new int[numCnt];
			
			visited = new boolean[swCnt+1][(int) Math.pow(10, numCnt)];
			for(int i = 0; i < num_str.length(); i++) {
				num[i] = num_str.charAt(i) - '0';
			}
			
			
			dfs(0);
			
			System.out.println("#" + test_case + " " + maxVal);


			
	
		}

	}
	
	static void dfs(int cnt) {
		if(cnt == swCnt) {
			maxVal = Math.max(calcVal(),maxVal);
			return;
		}
	
		int val = calcVal();
		if(visited[cnt][val]) return;
		
		visited[cnt][val] = true;
		
		for(int i=0;i<numCnt;i++) { 
			for(int j=i+1;j<numCnt;j++) {
				swap(i,j);
				dfs(cnt+1);
				swap(i,j);
			}
		}
			
	}		

	
	
	static void swap(int i, int j) {
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}

	static int calcVal() {
		int n = 0;
		int r = 1;
		for(int i=numCnt-1; i>= 0; i--) {
			n += (num[i]*r);
			r*=10;
		}
		return n;
	}

	
	
}
