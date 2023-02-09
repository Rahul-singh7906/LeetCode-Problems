class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        String ans="";
        int maxi=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int sz=hm.size();
        while(j<s.length()){
            char ch=s.charAt(j);
            if(hm.containsKey(ch)){
                int v=hm.get(ch);
                v-=1;
                hm.put(ch,v);
                if(v==0) sz--;
            }
            if(sz==0){ 
                while(sz==0){
                    int len=j-i+1;
                    if(len<maxi) {
                        maxi=len;
                        ans=s.substring(i,j+1);
                    }
                    char temp=s.charAt(i);
                    if(hm.containsKey(temp)){
                        hm.put(temp,hm.get(temp)+1);
                        if(hm.get(temp)==1) sz++;
                    }
                    i++;
                }
                j++;
            }
            else if(sz>0){            
                j++;
            }
        }
        return ans;
    }
}