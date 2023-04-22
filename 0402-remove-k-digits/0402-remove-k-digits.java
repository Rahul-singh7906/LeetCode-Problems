class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k) return "0";
        Stack<Character> st=new Stack<>();
        int i=0;
        while(i<num.length()){
            while(k>0 && !st.isEmpty() && st.peek()>num.charAt(i)){
                k--;
                st.pop();
            }
            st.push(num.charAt(i));
            i++;
        }
        while(k>0){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        if(sb.charAt(0)=='0'){
            while(sb.length()>1 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}