Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Input: nums = [2,7,11,15], target = 9
Output: [0,1]


we can solve this problem in 2 ways;

*******************************brute force**************************************************
time comp: O(n^2) and space comp: O(1);
public int[] twoSum(int[] numbers, int target) {
	int n= a.length;
	for(int i=0;i<n; i++){
		for(int j=i+1; j<n; j++){
			int sum= a[i]+a[j];
			if(sum== target) return new int[]{i, j};
		}
	}
}

********************************************** using hashmap*********************************
/*store the number and check if map contains number (target-num) if yes then upated the answer and return
example: target=10, and map contains 3, and the currect index number 7 so when we search in map (targer-num): (10-7)=3 and map contains this so we update ans and return
time comp: O(n) and space comp: O(n);*/

public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }
