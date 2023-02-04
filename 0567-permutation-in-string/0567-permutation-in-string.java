class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int i=0;
        int j=0;
        while(j<s2.length()){
            if(j-i+1<s1.length()){
                j++;
            }
            else{
                String str=s2.substring(i,j+1);
                if(solve(s1,str)==true) return true;
                i++;
                j++;
            }
        }
        return false;
    }
    public boolean solve(String s1,String s2){
        char[] ch1=new char[26];
        char[] ch2=new char[26];
        for(char ch:s1.toCharArray()){
            ch1[ch-'a']++;
        }
        for(char ch:s2.toCharArray()){
            ch2[ch-'a']++;
        }
        for(int i=0;i<s1.length();i++){
            char c1=s1.charAt(i);
            if(ch1[c1-'a']!=ch2[c1-'a']) return false;
        }
        return true;
    }
}