class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ls = new ArrayList<>();
        if(s.length()<p.length()) return ls;
        if(s.equals(p)) {
            ls.add(0);
            return ls;
        }
        int e=p.length();
        for(int i=0;i<s.length() && e<=s.length();i++){
            String str=s.substring(i,e);
            if(isCorrect(str,p)==true) ls.add(i);
            e++;
        }
        return ls;
    }
    public boolean isCorrect(String s,String p){
        char[] ch1=new char[26];
        for(char c:s.toCharArray()){
            ch1[c-'a']++;
        }
        char[] ch2=new char[26];
        for(char c:p.toCharArray()){
            ch2[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(ch1[i]!=ch2[i]) return false;
        }
        return true;
    }
}