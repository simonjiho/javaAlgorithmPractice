import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class SWExpert_1861 {
     
    static int minStart = Integer.MAX_VALUE;
    static int maxCnt = 0;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static int N;
 
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
 
            minStart = Integer.MAX_VALUE;
            maxCnt = 0;
             
            N = Integer.parseInt(br.readLine());
 
            int[][] arr = new int[N][N];
            boolean[][] visited = new boolean[N][N];
 
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
 
            for(int i = 0; i < N;i++) {
                for(int j = 0; j < N;j++) {
                    if(isLocalMin(i,j,arr)) dfs(arr[i][j], i,j, 1, arr);
                }
            }
 
 
 
            System.out.println("#" + test_case + " " + minStart + " " + maxCnt);
 
        }
 
    }
 
    static void dfs(int start, int i, int j, int cnt, int[][] arr) {
 
         
        if (maxCnt == cnt) {
            minStart = Math.min(minStart, start);
        } else if (maxCnt < cnt){
            maxCnt = cnt;
            minStart = start;
        }
         
        for(int k = 0; k < 4; k++) {
            int nextR = i + dy[k];
            int nextC = j + dx[k];
            if(!isValid(nextR,nextC)) continue;
            if(arr[i][j] + 1 != arr[nextR][nextC]) continue;
             
            dfs(start, nextR,nextC,cnt+1, arr);
        }
         
         
         
 
    }
     
    static boolean isValid(int r, int c) {
        return r < N && r >= 0 && c < N && c >= 0;
    }
    static boolean isLocalMin(int r, int c, int[][] arr) {
 
        boolean connectedToBiggerNum = false;
        for(int k = 0; k < 4; k++) {
            int prevR = r + dy[k];
            int prevC = c + dx[k];
            if(!isValid(prevR,prevC)) continue;
            if(arr[r][c] - 1 == arr[prevR][prevC]) {
                connectedToBiggerNum = true;
            }
        }
         
        return !connectedToBiggerNum;
    }
     
     
}
