class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
       
        List<List<Integer>> result = new ArrayList<>();

        int[] temp = new int[m*n];
        int idx = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               temp[idx++] = grid[i][j];
            }
        }

        k = k%(m*n);
        idx = temp.length - k;

        for(int i=0;i<m;i++){

            List<Integer> row = new ArrayList<>();
            for(int j=0;j<n;j++){
                if(idx==temp.length){
                  idx = 0;
                }
                row.add(temp[idx++]);
            }
            result.add(row);
            
        }

        return result;
    }
}