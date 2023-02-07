class Solution {
    public int totalFruit(int[] fruits) {
        int i=0;
        int j=0;
        int maxi=Integer.MIN_VALUE;
        HashSet<Integer> hs = new HashSet<>();
        while(i<fruits.length && j<fruits.length){
            if(hs.size()==0 || (hs.size()==1 && !hs.contains(fruits[j])) || (hs.size()==1 && hs.contains(fruits[j]))){
                hs.add(fruits[j]);
                maxi=Math.max(j-i+1,maxi);
                j++;
            }
            else if(hs.size()==2 && hs.contains(fruits[j])){
                maxi=Math.max(j-i+1,maxi);
                j++;
            }
            else{
                int st=fruits[i];
                while(fruits[i]==st) i++;
                j=i;
                hs.clear();
            }
        }
        return maxi;
    }
}