class Solution {
    public void helper(int[] nums, int index,List<List<Integer>> res,List<Integer> curr){
        if(index==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        // include
        curr.add(nums[index]);
        helper(nums,index+1,res,curr);
        curr.remove(curr.size() - 1);
        // not include. 
        helper(nums,index+1,res,curr);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        helper(nums,0,res,curr);
        return res;
    }
}