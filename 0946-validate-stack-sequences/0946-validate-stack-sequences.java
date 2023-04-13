class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length!=popped.length) return false;
        Stack<Integer> st=new Stack<>();
        int i=0;
        for(int it:pushed){
            st.push(it);
            while(!st.isEmpty() && i<popped.length && st.peek()==popped[i]){
                st.pop();
                i++;
            }
        }
        return i==popped.length;
    }
    
}