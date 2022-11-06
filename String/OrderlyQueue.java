/*899. Orderly Queue: https://leetcode.com/problems/orderly-queue/
You are given a string s and an integer k. You can choose one of the first k letters of s and append it at the end of the string..
Return the lexicographically smallest string you could have after applying the mentioned step any number of moves

approch:
1. if value of k>1 then we can return sorted String
   example:  s= "baaca", k = 2;
   if this case we can select any element from first 2 char and place at the end of the String;
   so flow if like: take a and place at end : bacaa
   now take b: acaab;
   now c: aaabc so this string is sorted, similarly if any k>1 we can make a sorted string so directly return sorted string;
   
 2. k==1 the we can select only one element at a time and place at the end, so we compare the string with s and if we found any lexographical small string we can upated the res and so on....
 time complaxity O(nLogn) due to sorting;
 
*/

class Solution {
   public String orderlyQueue(String S, int K) {
        if (K > 1) {
            char S2[] = S.toCharArray();
            Arrays.sort(S2);
            return new String(S2);
        }
        String res = S;
        for (int i = 1; i < S.length(); i++) {
            String tmp = S.substring(i) + S.substring(0, i);
            if (res.compareTo(tmp) > 0) res = tmp;
        }
        return res;
    }
}
