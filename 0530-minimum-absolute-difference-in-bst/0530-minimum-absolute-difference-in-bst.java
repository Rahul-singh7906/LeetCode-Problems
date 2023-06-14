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
    int mini=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        helper(root);
        return mini;
    }
    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        helper2(root,root.val);
        helper(root.right);
    }
    public void helper2(TreeNode root,int v){
        if(root==null) return;
        helper2(root.left,v);
        if(v-root.val!=0) mini=Math.min(mini,Math.abs(v-root.val));
        helper2(root.right,v);
    }
}