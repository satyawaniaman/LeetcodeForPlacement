class Solution {
    public String simplifyPath(String path) {
        Stack<String> st=new Stack<>();
        String[] components =path.split("/");
        for(String dr:components){
            if(dr.equals(".")||dr.isEmpty()){
                continue;
            }else if(dr.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.add(dr);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(String s:st){
            sb.append("/");
            sb.append(s);
        }
        return sb.length()>0?sb.toString():"/";
}
}