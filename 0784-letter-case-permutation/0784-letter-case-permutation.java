class Solution {
    List<String> ls = new ArrayList<>();
    HashSet<String> hs = new HashSet<>();
    public List<String> letterCasePermutation(String s) {
        helper(s,0);
        return ls;
    }
    public void helper(String s,int ind){
        if(ind==s.length()){
            if(!hs.contains(s)) {
                ls.add(s);
                hs.add(s);
            }
            return ;
        }
        if(ind>s.length()) return;
        helper(s,ind+1);
        char ch=s.charAt(ind);
        if((ch>='a' && ch<='z') || (ch>='A' && ch<='Z')){
            // System.out.println(s);
            s=changer(s,ind);
            // System.out.println(s);
            helper(s,ind+1);
        }
    }
    public String changer(String str,int ind){
        StringBuilder sb= new StringBuilder(str);
        char ch=str.charAt(ind);
        if(ch>='a' && ch<='z') sb.setCharAt(ind,Character.toUpperCase(ch));
        else sb.setCharAt(ind,Character.toLowerCase(ch));
        return sb.toString();
    }
}