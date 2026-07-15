class Solution {
    public int gcdOfOddEvenSums(int n) {
    
      int evensum =  n*(n+1);
      int oddsum = n*n;
      return GCD(evensum,oddsum);

    }

    int GCD(int a, int b){
        if(b==0){
            return a;
        }

        return GCD(b,a%b);
    }
}