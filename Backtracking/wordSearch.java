// LeetCode 79:   https://leetcode.com/problems/word-search/
/* to solve this problem we can use DFS method with backtracing
Impt point:
1. run a loop and find through out the array.
2. call dfs and check wethaer you are able to find the word or not.
3. for marking the element to be visited we can use a visited array or a XOR to change to value 
example : b[i][j]= A;  if we XOR with 256 it will give us a char 'Ł' and we again Xor with 256 it will give us A so we can use this;
*/


class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length, n= board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(word.charAt(0)==board[i][j]){
                    if(dfs(0, i, j, board, word)) return true;
                }
            }
        }
        return false;
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
}
