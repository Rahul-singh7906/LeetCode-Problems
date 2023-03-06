class Solution {
    public int findKthPositive(int[] arr, int k) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            hs.add(arr[i]);
        }
        ArrayList<Integer> ls = new ArrayList<>();
        for(int i=1;i<=arr[arr.length-1];i++){
            if(!hs.contains(i)) ls.add(i);
        }
        if(k<=ls.size()) return ls.get(k-1);
        return arr[arr.length-1]+(k-ls.size());
    }
}