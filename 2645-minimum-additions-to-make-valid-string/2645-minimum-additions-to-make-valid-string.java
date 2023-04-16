class Solution {
    public int addMinimum(String word) {
        int ct=0;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<word.length();i++){
            st.push(word.charAt(i));
        }
        while(!st.isEmpty()){
            if(!st.isEmpty() && st.peek()=='c'){
                st.pop();
            }
            else ct++;
            if(!st.isEmpty() && st.peek()=='b'){
                st.pop();
            }
            else ct++;
            if(!st.isEmpty() && st.peek()=='a'){
                st.pop();
            }
            else ct++;
        }
        return ct;
    }
}