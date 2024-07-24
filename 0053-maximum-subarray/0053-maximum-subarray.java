class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
		int curr=0;
        int negativeCount=0;
		for (int i = 0; i < nums.length; i++) {
			curr+=nums[i];
			if(curr<0) {
				curr=0;
                negativeCount++;
			}
			if(max<curr) {
				max=curr;
			}
            if(negativeCount==nums.length){
                Arrays.sort(nums);
                return nums[nums.length-1];
            }
		}
        return max;
    }
}