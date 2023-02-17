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
    int diff=Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        helper(root);
        return diff;
    }
    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        helper2(root,root);
        helper(root.right);
    }
    public void helper2(TreeNode root,TreeNode mmn){
        if(root==null) return;
        helper2(root.left,mmn);
        if(root!=mmn) diff=Math.min(Math.abs(mmn.val-root.val),diff);
        helper2(root.right,mmn);
    }
}