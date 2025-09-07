import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWExpert_1861_1 {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
		
			int N = Integer.parseInt(br.readLine());
			
			int[] nr = new int[N*N+1];
			int[] nc = new int[N*N+1];
			
			for(int i=0; i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N;j++) {
					int n = Integer.parseInt(st.nextToken());
					nr[n] = i;
					nc[n] = j;
				}
			}
			
			int maxStreak = 1;
			int streak = 1;
			int minStartN = 1;
			int startN = 1;
			for(int n=1; n<N*N; n++) {
				int dr = Math.abs(nr[n] - nr[n+1]);
				int dc = Math.abs(nc[n] - nc[n+1]);
				
				boolean onLR = (dr == 0) && (dc == 1);
				boolean onUD = (dc == 0) && (dr == 1);
				
				if(onLR || onUD) {
					streak++;
				} else {
					if(maxStreak < streak) {
						maxStreak = streak;
						minStartN = startN;
					}
					startN = n+1;
					streak = 1;
				}
 			}
			
			if(maxStreak < streak) {
				maxStreak = streak;
				minStartN = startN;			
			}
			
			System.out.printf("#%d %d %d\n", tc, minStartN, maxStreak);
			
		}
		
		
	
	}



	
	
}
