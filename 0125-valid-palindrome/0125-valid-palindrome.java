class Solution {
    public boolean isPalindrome(String s) {
        ArrayList<Character> arr = new ArrayList<>();
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if( (c >= 'a' && c <= 'z') || (c>='0' && c<='9')){
                arr.add(c);
            }
            }

        for(int j=0;j<arr.size()/2;j++){
            if(arr.get(j)!=arr.get(arr.size()-1-j)){
                return false;
            }
        }
        return true;
        }
        
    }
