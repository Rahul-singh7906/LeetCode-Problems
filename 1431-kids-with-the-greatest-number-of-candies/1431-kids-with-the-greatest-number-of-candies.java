class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ls=new ArrayList<>();
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<candies.length;i++){
            maxi=Math.max(maxi,candies[i]);
        }
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=maxi){
                ls.add(true);
            }
            else ls.add(false);
        }
        return ls;
    }
}