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
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder=new int[preorder.length];
        for(int i=0;i<preorder.length;i++){
            inorder[i]=preorder[i];
        }
        int n=preorder.length;
        Arrays.sort(inorder);
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<preorder.length;i++){
            hm.put(inorder[i],i);
        }
        TreeNode root=helper(preorder,inorder,0,n-1,0,n-1,hm);
        return root;
    }
    public TreeNode helper(int[] preorder,int[] inorder,int inStart,int inEnd,int prStart,int prEnd,HashMap<Integer,Integer> hm){
        if(inStart>inEnd || prStart>prEnd) return null;
        TreeNode root=new TreeNode(preorder[prStart]);
        int inRoot=hm.get(root.val);
        int numLeft=inRoot-inStart;
        root.left=helper(preorder,inorder,inStart,inRoot-1,prStart+1,prStart+numLeft,hm);
        root.right=helper(preorder,inorder,inRoot+1,inEnd,prStart+numLeft+1,prEnd,hm);
        return root;
    }
}