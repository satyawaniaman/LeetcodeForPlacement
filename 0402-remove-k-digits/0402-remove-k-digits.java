class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        for(char ch:num.toCharArray()){
            while(!st.isEmpty() && k>0 && st.peek()>ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        for(int i=0;i<k;i++){
            st.pop();
        }
        StringBuilder sb=new StringBuilder();
        boolean zero=true;
        for(char ch:st){
            if(zero && ch=='0'){
                continue;
            }
            zero=false;
            sb.append(ch);
        }
        if(sb.length()==0) return "0";
        else{
            return sb.toString();
        }
        
    }
}