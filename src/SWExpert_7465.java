import java.io.BufferedReader;
import java.io.InputStreamReader;



public class SWExpert_7465 {
//	static int N;
	
	static int[] p;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		

		int T = Integer.parseInt(br.readLine());
		
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			String[] input = br.readLine().split(" ");
			
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			
			p = new int[N+1];
			for(int i=0; i<N+1;i++) p[i] = i;
			
			for(int i = 0; i<M; i++) {
				String[] input2 = br.readLine().split(" ");
				int n1 = Integer.parseInt(input2[0]);
				int n2 = Integer.parseInt(input2[1]);
				union(n1, n2);
			}
			
			boolean[] isRoot = new boolean[N+1];
			int cnt = 0;

			for(int i=1; i<N+1; i++) {
				if(isRoot[find(i)]) continue;
				cnt++;
				isRoot[find(i)] = true;
			}
	
			System.out.println("#" + test_case + " " + cnt);
			
		}			

		
		
	}
	static void union(int i, int j) {
		if(find(i) == find(j)) return;
		
		int root1 = find(i);
		int root2 = find(j);
		p[root2] = root1;
		
	}
	
	static int find(int i) {
		if(p[i] == i) return i;
		else return find(p[i]);
	}
}


