class Solution {
    public int maxVowels(String s, int k) {
        int ct=0;
        int maxi=0;
        int i=0;
        int j=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(ch=='a'|| ch=='e'|| ch=='i' || ch=='o' || ch=='u'){
                ct++;
            }
            if(j-i+1<k) j++;
            else if(j-i+1==k){
                maxi=Math.max(maxi,ct);
                char ch2=s.charAt(i);
                if(ch2=='a'|| ch2=='e'|| ch2=='i' || ch2=='o' || ch2=='u'){
                    ct--;
                }
                i++;
                j++;
            }
        }
        return maxi;
    }
}