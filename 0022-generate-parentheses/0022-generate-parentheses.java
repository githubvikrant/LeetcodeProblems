class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();
        
        generate(result,n,"",0,0);

        return result;
        
    }
      // good question
    void generate(List<String> result,int n,String current,int open, int close){
        if(open == n && close == n){
            result.add(current);
            return;
        }

        if(open<n){
            generate(result,n,current+"(",open+1,close);
        }

        if(close<open){
            generate(result,n,current+")",open,close+1);
        }

        return;
    }
}