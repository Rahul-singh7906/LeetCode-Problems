/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp=head;
        int sz=0;
        while(temp!=null){
            sz++;
            temp=temp.next;
        }
        int[] arr=new int[sz];
        temp=head;
        int ind=0;
        while(temp!=null){
            arr[ind]=temp.val;
            temp=temp.next;
            ind++;
        }
        return helper(arr,0,sz-1);
    }
    public TreeNode helper(int[] nums,int s,int e){
        if(s>e) return null;
        if(s==e) return new TreeNode(nums[s]);
        int m=(s+e)/2;
        TreeNode root=new TreeNode(nums[m]);
        root.left=helper(nums,s,m-1);
        root.right=helper(nums,m+1,e);
        return root;
    }
}