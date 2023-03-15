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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        List<List<TreeNode>> res = new ArrayList<>();
        int e=0;
        while(!q.isEmpty()){
            int s=q.size();
            List<TreeNode> ls = new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode node=q.poll();
                if(node==null) e=1;
                else{
                    if(e==1) return false;
                    q.add(node.left);
                    q.add(node.right);
                }
            }
        }
        return true;
    }
}