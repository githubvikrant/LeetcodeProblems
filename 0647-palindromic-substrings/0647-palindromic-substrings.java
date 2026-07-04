class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int totalSubS = 0;

        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String sub = s.substring(i,j+1);
                // System.out.println(sub);
                if(isPalindrome(sub)){
                    totalSubS++;
                }
            }
        }

        return totalSubS;

    }

    boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}