class Solution {
    public int coinChange(int[] coins, int amount) {

        if (amount < 1) {
            return 0;
        }
    
        int[] dp = new int[amount+1];
       
        for(int i=1;i<=amount;i++){
           dp[i] = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                   int remain = i - coins[j];
                   if(dp[remain] != Integer.MAX_VALUE){
                     dp[i] = Math.min(dp[i],1+dp[remain]);
                   }
                }
            }
        }

       if(dp[amount] == Integer.MAX_VALUE){
        return -1;
       }else{
        return dp[amount];
       }

    }
}