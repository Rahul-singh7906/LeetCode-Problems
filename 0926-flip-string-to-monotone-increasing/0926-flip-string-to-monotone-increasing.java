class Solution {
    public int minFlipsMonoIncr(String s) {
        int zero=0;
        for(char c:s.toCharArray()){
            if(c=='0') zero++;
        }
        int temp=zero;
        int one=0;
        for(char c:s.toCharArray()){
            if(c=='0') zero--;
            else one++;
            temp=Math.min(temp,zero+one);
        }
        return temp;
    }
}