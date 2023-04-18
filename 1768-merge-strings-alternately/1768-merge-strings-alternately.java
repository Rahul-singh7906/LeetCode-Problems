class Solution {
    public String mergeAlternately(String word1, String word2) {
        String str="";
        int ind=0;
        for(int i=0;i<word1.length() && i<word2.length();i++){
            str+=word1.charAt(i);
            str+=word2.charAt(i);
            ind=i;
        }
        ind++;
        if(ind<word1.length()) str+=word1.substring(ind,word1.length());
        if(ind<word2.length()) str+=word2.substring(ind,word2.length());
        return str;
    }
}