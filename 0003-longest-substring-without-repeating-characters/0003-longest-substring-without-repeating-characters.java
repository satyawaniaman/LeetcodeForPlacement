class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap < Character, Integer > map = new HashMap < Character, Integer > ();
        int l=0,r=0;
        int length=0;
        int n=s.length();
        while(r<n){
            if(map.containsKey(s.charAt(r))){
                l=Math.max(map.get(s.charAt(r))+1,l);
            }
            map.put(s.charAt(r),r);
            length=Math.max(length,r-l+1);
            r++;
        }
        return length;
    }
}