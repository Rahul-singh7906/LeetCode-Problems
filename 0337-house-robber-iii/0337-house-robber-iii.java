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
   HashMap<TreeNode,Integer> hm = new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null) return 0;
        if(hm.containsKey(root)) return hm.get(root);
        int val=0;
        if(root.left!=null){
            val+=rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null){
            val+=rob(root.right.left)+rob(root.right.right);
        }
        val= Math.max(val+root.val,(rob(root.left)+rob(root.right)));
        hm.put(root,val);
        return val;
    }
}