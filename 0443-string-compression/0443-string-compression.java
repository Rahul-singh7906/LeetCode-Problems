class Solution {
    public int compress(char[] chars) {
        int len=chars.length;
        List<Character> ls = new ArrayList<>();
        for(int i=0;i<chars.length;i++){
            int ct=1;
            int ind=i;
            ls.add(chars[ind]);
            if(i+1<chars.length && chars[i]==chars[i+1]){
                while(i+1<chars.length && chars[i]==chars[i+1]){
                    i++;
                    ct++;
                }
                
                if(ct==2){
                    ls.add((char)(ct+'0'));
                    // if(ind+1<chars.length) chars[ind+1]=(char)(ct+'0');
                }
                else if(ct>2 && ct<10){
                    len=len-ct;
                    len+=2;
                    ls.add((char)(ct+'0'));
                    // if(ind+1<chars.length) chars[ind+1]=(char)(ct+'0');
                }
                else if(ct>=10){
                    String str=Integer.toString(ct);
                    len-=ct;
                    len+=str.length()+1;
                    
                    int k=0;
                    while(k<str.length() ){
                        // chars[ind+1]=str.charAt(k);
                        ls.add(str.charAt(k));
                        k++;
                        // ind++;
                    }
                }
            }
        }
        for(int p=0;p<ls.size();p++){
            chars[p]=ls.get(p);
        }
        return len;
    }
}