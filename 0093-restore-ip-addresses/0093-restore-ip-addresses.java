class Solution {
    List<String> ls = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length()<4 || s.length()>12) return ls;
        helper(s,"",0,0);
        return ls;
    }
    public void helper(String s,String str,int ind,int part){
        if(ind==s.length()|| part==4){
            if(ind==s.length() && part==4) ls.add(str.substring(0,str.length()-1));
            return;
        }
        helper(s,str+s.charAt(ind)+".",ind+1,part+1);
        if(ind+2<=s.length() && isValid(s.substring(ind,ind+2))) helper(s,str+s.substring(ind,ind+2)+".",ind+2,part+1);
        if(ind+3<=s.length() && isValid(s.substring(ind,ind+3))) helper(s,str+s.substring(ind,ind+3)+".",ind+3,part+1);
    }
    public boolean isValid(String s){
        if(s.charAt(0)=='0') return false;
        return Integer.parseInt(s)<=255;
    }
}