/* 446. Arithmetic Slices II - Subsequence: https://leetcode.com/problems/arithmetic-slices-ii-subsequence/

To find the all the subsequence with equal distance we use DP approch
Import points
1. for finding subsequence we need to create a create a Map array which store differce & freq of the differnce >=2;
2. we itreate from index i till the end of given array and create a pointer j which always less than i: 0<j<i;
3. for every i we iterate j from 0 to i and strore the differnce in map array;
4. add the j pointer differnce's freq answer variable and store in map freq at i pointer map & j poniter in the map : freq_at_i + freq_at_j + 1 (1 more to increase the freq every time.

example: input array [2,4,6,8,10];
value   | 2 | 4     | 6      | 8      | 10      | map store the value : diff, freq of dif.
index : | 0 | 1     | 2      | 3      | 4       | i go from i to n-1
        |   | <2,1> | <4,1>  |  <6,1> |  <8.1>  | j go from 0 to i every time
        |   |       | <2,2>  |  <4,1> |  <6,1>  | add value of freq at j to ans and incearse freq at i by 1
        |   |       |        |  <2,3> |  <4,2>  | ans= 0,(0+1=1), (1+2=3),(3+3+1=7) our final answer= 7
        |   |       |        |        |  <2,4>  |
        |   |       |        |        |         |
        |   |       |        |        |         |
*/

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3) return 0;
        int n= nums.length;
        int ans=0;
        Map<Integer, Integer>[] map= new Map[n];
        for(int i=0; i<n; i++){
            map[i]= new HashMap<>();
            
            for(int j=0; j<i; j++){
                long dif= (long)nums[i]- (long)nums[j];
                if(dif<= Integer.MIN_VALUE || dif>=Integer.MAX_VALUE) continue;
                
                
                int c1 = map[i].getOrDefault((int)dif, 0);
                int c2 = map[j].getOrDefault((int)dif, 0);
                ans+= c2;
                map[i].put((int)dif, c1+c2 +1);
            }
        }
        return ans;
    }

}
