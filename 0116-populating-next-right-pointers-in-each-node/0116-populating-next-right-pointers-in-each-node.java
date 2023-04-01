/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        if(root==null) return root;
        while(!q.isEmpty()){
            int sz=q.size();
            List<Node> ls = new ArrayList<>();
            for(int i=0;i<sz;i++){
                Node node=q.poll();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                ls.add(node);
            }
            for(int i=0;i<ls.size();i++){
                Node node=ls.get(i);
                if(i==ls.size()-1) node.next=null;
                else{
                    node.next=ls.get(i+1);
                }
            }
        }
        return root;
    }
}