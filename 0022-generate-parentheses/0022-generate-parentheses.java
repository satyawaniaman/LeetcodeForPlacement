class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        helper(n,0,0,res,"");
        return res;
    }
    public void helper(int n,int open,int closed,List<String>res,String curr){
        if(closed==n){
            res.add(curr);
            return;
        }
        // pick opening
        if(open<n){
            helper(n,open+1,closed,res,curr+'(');
        }
        if(open>closed){
            helper(n,open,closed+1,res,curr+')');
        }
    }
}