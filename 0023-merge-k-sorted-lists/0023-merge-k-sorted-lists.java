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
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(int i=0;i<lists.length;i++){
            ListNode now=lists[i];
            ListNode temp=now;
            while(temp!=null){
                pq.add(temp);
                temp=temp.next;
            }
        }
        ListNode ans=null;
        ListNode temp=ans;
        while(!pq.isEmpty()){
            ListNode v=new ListNode(pq.poll().val);
            if(ans==null){
                ans=v;
                temp=ans;
            }
            else{
                temp.next=v;
                temp=v;
            }
        }
        return ans;
    }
}