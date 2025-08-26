import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWExpert_15861 {

    static int[] parent;
    static int[] rank;

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 경로 압축
        }
        return parent[x];
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;

        // rank 기준 합치기
        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } else if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        } else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int c2yCnt = 0;

            parent = new int[N + 1];
            rank = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                parent[i] = i;
                rank[i] = 0;
            }

            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                int c = Integer.parseInt(input[0]);
                int p1 = Integer.parseInt(input[1]);
                int p2 = Integer.parseInt(input[2]);

                if (c == 1) { // 팀 합치기
                    union(p1, p2);
                } else { // 같은 팀 여부 확인
                    if (find(p1) == find(p2)) {
                        c2yCnt++;
                    }
                }
            }

            System.out.println("#" + test_case + " " + c2yCnt);
        }
    }
}
