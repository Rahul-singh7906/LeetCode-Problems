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
    int ans=0;
    int kin;
    public int kthSmallest(TreeNode root, int k) {
        kin=k;
        helper(root);
        return ans;
    }
    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        kin-=1;
        if(kin==0) {
            ans=root.val;
            return;
        }
        helper(root.right);
    }
}