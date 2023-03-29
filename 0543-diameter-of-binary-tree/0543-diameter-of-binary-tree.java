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
    int maxi=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        traversal(root);
        return maxi;
    }
    public void traversal(TreeNode root){
        if(root==null) return;
        traversal(root.left);
        int h1=helper(root.left);
        int h2=helper(root.right);
        maxi=Math.max(maxi,(h1+h2));
        traversal(root.right);
    }
    public int helper(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(helper(root.left),helper(root.right));
    }
}