class Solution {
    public String addBinary(String a, String b) {
        int c=0;
        int i=a.length()-1;
        int j=b.length()-1;
        String ans="";
        while(i>=0 || j>=0){
            int v1=0;
            if(i>=0) v1=a.charAt(i)-'0';
            int v2=0;
            if(j>=0) v2=b.charAt(j)-'0';
            if(v1==1 && v2==1){
                ans+=(c);
                c=1;
            }
            else{
                int temp=(v1+v2+c);
                if(temp==2){
                    ans+=0;
                    c=1;
                }
                else if(temp==1){
                    c=0;
                    ans+=1;
                }
                else{
                    c=0;
                    ans+=0;
                }
            }
            i--;
            j--;
        }
        if(c==1) ans+=c;
        String ans2="";
        for(int k=ans.length()-1;k>=0;k--){
            ans2+=ans.charAt(k);
        }
        return ans2;
    }
}