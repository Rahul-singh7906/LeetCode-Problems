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
    // int ans=0;
    List<Integer> ls = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return ls.get(k-1);
    }
    public void helper(TreeNode root,int k){
        if(root==null) return;
        helper(root.left,k);
        // k-=1;
        // if(k==0) ans=root.val;
        ls.add(root.val);
        helper(root.right,k);
    }
}