class Solution {
    public int strStr(String haystack, String needle) {
        int ind=-1;
        if(needle.length()>haystack.length() || haystack.length()==0 || needle.length()==0) return ind;
        int len=needle.length();
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                if(i+len<=haystack.length()){
                    String str=haystack.substring(i,i+len);
                    if(str.equals(needle)){
                        ind=i;
                        break;
                    }
                }
            }
        }
        return ind;
    }
}