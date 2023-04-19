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
    public int longestZigZag(TreeNode root) {
        helper(root,0,0);
        helper(root,1,0);
        return ans;
    }
    public void helper(TreeNode root,int f,int st){
        if(root==null){
            return;
        }
        ans=Math.max(ans,st);
        if(f==0) {
            helper(root.left,1,st+1);
            helper(root.right,0,1);
        }
        if(f==1) {
            helper(root.right,0,st+1);
            helper(root.left,1,1);
        }
    }
}