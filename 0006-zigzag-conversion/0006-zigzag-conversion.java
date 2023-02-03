class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        StringBuilder str = new StringBuilder();
        int n = s.length();
        int k = 2* (numRows -1);
        for(int i=0;i<numRows;i++){
            int index = i ;
            while(index<n){
                str.append(s.charAt(index));
                if(i!=0 && i!=numRows-1){
                    int k1 = k- (2*i);
                    int k2 = index + k1;
                    if(k2<n){
                        str.append(s.charAt(k2));
                    }
                }
                index = index + k;   
            }
        }
        return str.toString();
    }
}












// public String convert(String s, int n) {
//        // int m=n-1;
//         String str="";
//         for(int i=0;i<n;i++){
//             // int left=n-(i+1);
//             int j=i;
//             if(i==0){              
//                 while(j<s.length()){
//                     str+=s.charAt(j);
//                     int v=getDn(i,n);
//                     j=j+v;
//                 }
//             }
//             else if(i>0 && i<n-1){               
//                 while(j<s.length()){
//                     str+=s.charAt(j);
//                     int v=getDn(i,n);
//                     j+=v;
//                     if(j<s.length())  str+=s.charAt(j);
//                     v=getUp(i);
//                     j+=v;                
//                 }
//             }
//             else if(i==n-1){
//                 while(j<s.length()){
//                     str+=s.charAt(j);
//                     int v=getUp(i);
//                     j+=v;
//                 }
//             }
//         }
//         return str;
//     }
//     public int getDn(int i,int n){
//         int v=2*(n-(i+1));
//         return v;
//     }
//     public int getUp(int i){
//         int v=2*i;
//         return v;
//     }