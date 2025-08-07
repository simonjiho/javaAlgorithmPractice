
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SWExpert_1204 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int t = Integer.parseInt(br.readLine());
			int[] scores = new int[101];
			String[] s = br.readLine().split(" ");
			for(int i = 0; i < 1000; i++) {
				scores[Integer.parseInt(s[i])] += 1;
			}
			
			int ans = 0;
			int maxCnt = 0;
			for(int i = 0; i < 101; i++) {
				if (maxCnt <= scores[i]) {
					ans = i;
					maxCnt = scores[i];
				}
			}
			
			System.out.println("#" + test_case + " " + ans);
		}
		
		
	}
}
