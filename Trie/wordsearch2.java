/* 212. Word Search II : https://leetcode.com/problems/word-search-ii/
this solution gives TLE
using HashMap Or brute force approch
*/
public List<String> findWords(char[][] board, String[] words) {
        int m=board.length, n= board[0].length;
        Map<Character, List<String>> map = new HashMap();
         for(String s: words){
             char c= s.charAt(0);
             if(!map.containsKey(c)) map.put(c, new ArrayList<>());
             map.get(c).add(s);
         }
        
        Set<String> set= new HashSet<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map.containsKey(board[i][j])){
                    for(String word: map.get(board[i][j])){
                        if(dfs(0, i, j, board, word)) set.add(word);
                        
                    }
                }
            }
        }
        return new ArrayList<String>(set);
    }
    boolean dfs(int ind, int i, int j, char[][] b, String word){
            if(ind==word.length()) return true;
            if(i<0 || i>b.length-1 || j<0 || j> b[0].length-1|| word.charAt(ind)!= b[i][j]) return false;
            
            b[i][j] ^= 256;
         boolean ex=  dfs(ind+1, i+1, j, b, word)|| dfs(ind+1, i-1, j, b, word)
                || dfs(ind+1, i, j+1, b, word)|| dfs(ind+1, i, j-1, b, word);
            b[i][j] ^= 256;
            return ex;
        }
//**********************************************************************************************************************************//
/* trie solution
points:
create a trie with all given words and at the end of the word except marking it true for false we can use word it self to check;

*/
public List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();
    TrieNode root = buildTrie(words);
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            dfs (board, i, j, root, res);
        }
    }
    return res;
}

public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
    char c = board[i][j];
    if (c == '#' || p.next[c - 'a'] == null) return;
    p = p.next[c - 'a'];
    if (p.word != null) {   // found one
        res.add(p.word);
        p.word = null;     // de-duplicate
    }

    board[i][j] = '#';
    if (i > 0) dfs(board, i - 1, j ,p, res); 
    if (j > 0) dfs(board, i, j - 1, p, res);
    if (i < board.length - 1) dfs(board, i + 1, j, p, res); 
    if (j < board[0].length - 1) dfs(board, i, j + 1, p, res); 
    board[i][j] = c;
}

public TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String w : words) {
        TrieNode p = root;
        for (char c : w.toCharArray()) {
            int i = c - 'a';
            if (p.next[i] == null) p.next[i] = new TrieNode();
            p = p.next[i];
       }
       p.word = w;
    }
    return root;
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}

