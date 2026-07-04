class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0 || s == null){
            return "";
        }
        String maxStr = "";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String subString = s.substring(i,j+1);
                if(isPalindrome(subString)){
                    int len = subString.length();
                    if(len>maxStr.length()){
                        maxStr = subString;
                    }
                }
            }
        }
        return maxStr;
    }

    boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<=right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}