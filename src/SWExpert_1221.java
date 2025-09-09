import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SWExpert_1221 {
	
	static String[] inString = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());

		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[1]);
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] cnt = new int[10];
			
			for(int i = 0; i < N; i++) {
				String w = st.nextToken();
				for(int n = 0;n < 10; n++) {
					if(w.equals(inString[n])) {cnt[n]++; break;}
				}
			}
			
			System.out.println("#" + test_case);

			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 10; i++) {
				String str = inString[i];
				for(int k = 0; k < cnt[i]; k++) {
					sb.append(str + " ");
				}
			}
			
			String result = sb.toString();
			
			System.out.println(result.substring(0, result.length()-1));
			
		}			

		
		
	}
	
}
