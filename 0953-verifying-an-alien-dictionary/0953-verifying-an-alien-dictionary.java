class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] arr=new int[26];
        for(int i=0;i<26;i++){
            arr[order.charAt(i)-'a']=i;
        }
        for(int i=0;i<words.length-1;i++){
            String s1=words[i];
            String s2=words[i+1];
            int p=0;
            int f=0;
            while(p<s1.length() && p<s2.length()){
                char ch1=s1.charAt(p);
                char ch2=s2.charAt(p);
                if(ch1!=ch2){
                    if(arr[ch1-'a']>arr[ch2-'a']) {
                        return false;
                    }
                    f=1;
                    break;
                }
                p++;
            }
           if(s1.length()>s2.length() && f==0) return false;
        }
        return true;
    }
}