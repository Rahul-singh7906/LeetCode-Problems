class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s.length()==1){
            List<String> ls = new ArrayList<>();
            ls.add(s);
            ans.add(new ArrayList<>(ls));
            return ans;
        }
        helper(new ArrayList<>(),s,0);
        return ans;
    }
    public void helper(List<String> ls,String s,int ind){
        if(ind==s.length()){
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(i+1<=s.length() && isValid(s.substring(ind,i+1))){
                ls.add(s.substring(ind,i+1));
                helper(ls,s,i+1);
                ls.remove(ls.size()-1);
            }
        }
    }
    public boolean isValid(String s){
        if(s.length()==1) return true;
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}