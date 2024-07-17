class Solution {
    public void swap(int[] nums,int first,int second){
            int temp=nums[first];
            nums[first]=nums[second];
            nums[second]=temp;
        }
    public int missingNumber(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct=nums[i];
            if(nums[i]<nums.length && nums[i]!=nums[correct]){
                swap(nums,correct,i);
            }else{
                i++;
            }
        }
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j){
                return j;
            }
        }
        return nums.length;
    }
}