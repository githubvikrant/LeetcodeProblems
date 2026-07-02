class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      // Convert list to HashSet for O(1) lookups
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        
        // Base case: an empty string can always be segmented
        dp[0] = true;
        
        // Check every prefix of the string
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // If prefix s[0...j] is valid AND substring s[j...i] is in dict
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // Move to the next outer loop index i
                }
            }
        }
        
        return dp[n];
    }
}