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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> adj= new ArrayList<>();
        if(root==null) return adj;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int f=0;
        while(!q.isEmpty()){
            int s=q.size();
            List<Integer> ls = new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode node=q.poll();
                if(node!=null && node.left!=null) q.add(node.left);
                if(node!=null && node.right!=null) q.add(node.right);
                if(node!=null) ls.add(node.val);
            }
            if(f==0){
                adj.add(new ArrayList<>(ls));
                f=1;
            }
            else{
                Collections.reverse(ls);
                adj.add(new ArrayList<>(ls));
                f=0;
            }
        }
        return adj;
    }
}