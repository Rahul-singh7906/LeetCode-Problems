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
    List<Integer> ls = new ArrayList<>();
    public int pathSum(TreeNode root, int targetSum) { 
        helper2(root,targetSum,0);
        return ans;
    }
    public void helper2(TreeNode root,int target,long temp){
        if(root==null) return;
        ls.add(root.val);
        helper2(root.left,target,0);
        helper2(root.right,target,0);
        for(int i=ls.size()-1;i>=0;i--){
            temp+=ls.get(i);
            if(temp==target) ans++;
        }
        ls.remove(ls.size()-1);
    }
    
}