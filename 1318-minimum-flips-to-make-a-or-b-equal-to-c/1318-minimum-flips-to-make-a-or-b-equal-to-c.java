class Solution {
    public int minFlips(int a, int b, int c) {
        int ct=0;
        for(int i=0;i<31;i++){
            int v1=(1 << i) & a;
            int v2=(1 << i) & b;
            int cmp=(1 << i) & c;
            if(v1==0 && v2==0 && cmp>0) ct+=1;
            else if(((v1==0 && v2>0)||(v1>0 && v2==0)) && cmp==0) ct+=1;
            else if(v1>0 && v2>0 && cmp==0) ct+=2;
        }
        return ct;
    }
}