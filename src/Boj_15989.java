//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Collections;
//
//// 15:10 시작
//
//public class Boj_15989 {
//	
//	
//
//	
//	public static void main(String args[]) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		int T = Integer.parseInt(br.readLine());
//		dp1[1] = 1; dp[1] = 1;
//		dp1[2] = 1; dp2[2] = 1; dp[2] = 1;
//		
//	
//		for(int t = 0; t < T; t++) {
//			
//			int N = Integer.parseInt(br.readLine());
//			
//			if(dp[N] != 0) { System.out.println(dp[N]); }
//			else {
//				
//				for(int i = 1; i < N; i++) {
//					dp[i] = dp1[i-1] + dp2[i-1] + dp[i-1];
//					
//					dp1[i] = dp1[i-1] + dp1[i-1];
//					
//				}
//			
//			}
//		}
//		
//	}
//		
//	
//	static int recur(int n) {
//		if (n <= 3) return n;
//		
//		if ( dp[n] == 0 ) {
//			dp[n] = dp[n-1]
//		}
//			int value = dp[n-1] + recur(n-1 + recur(n-1);
//			dp[n] = value;
//		}
//		
//		return dp[n];
//
//	}
//		
//
//	static class Combi {
//		int numOf1;
//		int numOf2;
//		int numOf3;
//		Combi(int a, int b, int c) {
//			this.numOf1 = a;
//			this.numOf1 = b;
//			this.numOf1 = c;
//		}
//	}
//	
//}
