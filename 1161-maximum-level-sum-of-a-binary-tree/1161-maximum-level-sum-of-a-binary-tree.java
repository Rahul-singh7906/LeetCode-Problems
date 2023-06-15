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
    public int maxLevelSum(TreeNode root) {
        int level=-1;
        long sm=Long.MIN_VALUE;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int ct=1;
        while(!q.isEmpty()){
            int s=q.size();
            long temp=0;
            for(int i=0;i<s;i++){
                TreeNode node=q.poll();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                temp+=node.val;
            }
            if(temp>sm){
                sm=temp;
                level=ct;
            }
            ct++;
        }
        return level;
    }
}