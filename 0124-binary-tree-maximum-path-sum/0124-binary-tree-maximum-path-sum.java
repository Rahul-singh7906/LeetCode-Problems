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
    public int maxPathSum(TreeNode root) {
        if(root.left==null && root.right==null) return root.val;
        helper(root);
        return maxi;
    }
    public int helper(TreeNode root){
        if(root==null) return 0;
        int lf=Math.max(helper(root.left),0);
        int rt=Math.max(helper(root.right),0);
        maxi=Math.max(lf+rt+root.val,maxi);
        return root.val+Math.max(lf,rt);
    }
}