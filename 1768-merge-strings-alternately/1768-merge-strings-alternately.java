class Solution {
    public String mergeAlternately(String word1, String word2) {
        String str="";
        int i=0;
        int j=0;
        int f=0;
        while(i<word1.length() && j<word2.length()){
            if(f==0) {
                str+=word1.charAt(i++);
                f=1;
            }
            else{
                str+=word2.charAt(j++);
                f=0;
            }
        }
        while(i<word1.length()) str+=word1.charAt(i++);
        while(j<word2.length()) str+=word2.charAt(j++);
        return str;
    }
}