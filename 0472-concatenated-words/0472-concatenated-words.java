class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> hs = new HashSet<>();
        for(int i=0;i<words.length;i++){
            hs.add(words[i]);
        }
        List<String> ls = new ArrayList<>();
        for(int i=0;i<words.length;i++){
           if(helper(words[i],hs)==true){
               ls.add(words[i]);
           }
        }
        return ls;
    }
    public boolean helper(String str,Set<String> hs){
        for(int i=1;i<str.length();i++){
            String s1=str.substring(0,i);
            String s2=str.substring(i,str.length());
            if(hs.contains(s1) && (hs.contains(s2) || helper(s2, hs))) return true;
        }
        return false;
    }
}