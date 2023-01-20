class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> adj= new ArrayList<>();
        if(nums.length==1) {
            return adj;
        }
        helper(nums,new ArrayList<>(),adj,0);
        return adj;
    }
    public void helper(int[] arr,List<Integer> ls,List<List<Integer>> adj,int i){
        if(i==arr.length){
            if(ls.size()>=2){
                adj.add(new ArrayList<>(ls));
            }
            return;
        }
        if(ls.size()==0 || arr[i]>=ls.get(ls.size()-1)){
            ls.add(arr[i]);
            helper(arr,ls,adj,i+1);
            ls.remove(ls.size()-1);
        }
        if(ls.size()==0 || arr[i]!=ls.get(ls.size()-1)) helper(arr,ls,adj,i+1);
    }
}