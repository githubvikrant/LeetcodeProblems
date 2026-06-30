/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        //go for a inorder traversal and maintain an array upto size k
        List<Integer> items = new ArrayList<>();
        inorder(root,items,k);
        return items.get(k-1);
    }

    void inorder(TreeNode root,List<Integer> items,int k){
        if(root == null){
            return;
        }
       if(items.size()>=k){
         return;
       }
        
        inorder(root.left,items,k);
        items.add(root.val);
        inorder(root.right,items,k);

    }
}