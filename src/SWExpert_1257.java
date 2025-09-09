import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class SWExpert_1257 {


	
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{

			int K = Integer.parseInt(br.readLine());
			
			String word = br.readLine();
			int wLen = word.length();
			
			Trie trie = new Trie();
			
			for(int i = 0; i < wLen; i++) {
				for(int j = i+1; j <= wLen; j++) {
					String subS = word.substring(i,j);
					trie.insert(subS);
				}
			}
			
			String ans = trie.find(K);
			
			
			
			
			System.out.println("#" + test_case + " " + ans);
			
		}
			
			

		
		
		
	}

	
	private static class TrieNode {
		TrieNode[] child = new TrieNode[26];
		int cnt;
	}
	
	private static class Trie {
		TrieNode root = new TrieNode();
		StringBuilder sb = new StringBuilder();
		
		void insert(String s) {
			if(contains(s)) return;

			TrieNode node = root;
			
			for(int i = 0; i < s.length(); i++) {
				int idx = s.charAt(i) - 'a';
				
				if(node.child[idx] == null) {
					node.child[idx] = new TrieNode();
				}
				
				node = node.child[idx];
				node.cnt++;

			}
			
		}
		
		boolean contains(String s) {
			TrieNode node = root;
			boolean containsS = true;
			for(int i = 0; i < s.length(); i++) {
				int idx = s.charAt(i) - 'a';
				if(node.child[idx] != null) node = node.child[idx];
				else {containsS = false; break;}
			}
			
			return containsS;
		}
		
		
		String find(int n) {
			if (root.cnt < n) return "none";
			
			
			TrieNode node = root;
			int cnt = 0;
			
			while(cnt < n) {
				
				for(int i = 0; i < 26; i++) {
					if(node.child[i] == null) continue;
					if(cnt + node.child[i].cnt < n) cnt += node.child[i].cnt;
					else {
						node = node.child[i];
						sb.append((char)('a'+i));
						cnt++;
						break;
					}
				}
				

			}
			
			System.out.println(cnt == n);
			
			String result = sb.toString();
			sb = new StringBuilder();
			return result;
			
			
		}
		
	}
	

}

