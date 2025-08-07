
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class SWExpert_1208 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			
			int N = Integer.parseInt(br.readLine());
			
			String[] s = br.readLine().split(" ");
			
			int[] height = new int[100];
			for(int i = 0; i < 100; i++) {
				height[i] = Integer.parseInt(s[i]);
			}
			
			for(int i=0; i < N; i++) {
				
				int maxH = 0;
				int minH = Integer.MAX_VALUE;
				int maxIdx = 0;
				int minIdx = 0;
				
				for(int j = 0; j < 100; j++) {
					if ( maxH < height[j] ) {
						maxIdx = j;
						maxH = height[j];
					}
					if ( minH > height[j] ) {
						minIdx = j;
						minH = height[j];
					}				
				}
				
				height[minIdx]++;
				height[maxIdx]--;
				
				
			}
			

			int maxH_fin = Arrays.stream(height).max().getAsInt();
			int minH_fin = Arrays.stream(height).min().getAsInt();
			int ans = maxH_fin - minH_fin;
			
			

			System.out.println("#" + test_case + " " + ans);
			
		}			

		
		
	}
}
