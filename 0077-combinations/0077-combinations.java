class Solution {
     public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        // Base case: combination is complete
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Optimization (Pruning): Ensure there are enough remaining elements to reach size k
        // "k - current.size()" is how many more elements we need
        for (int i = start; i <= n - (k - current.size()) + 1; i++) {
            current.add(i);                             // Make a choice
            backtrack(i + 1, n, k, current, result);    // Recurse to next step
            current.remove(current.size() - 1);         // Backtrack (undo choice)
        }
    }
}