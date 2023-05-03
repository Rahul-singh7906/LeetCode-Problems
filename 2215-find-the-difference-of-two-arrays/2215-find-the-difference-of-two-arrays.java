class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            hs1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            hs2.add(nums2[i]);
        }
        List<List<Integer>> adj=new ArrayList<>();
        List<Integer> ls1=new ArrayList<>();
        List<Integer> ls2=new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            if(!hs2.contains(nums1[i])) if(!ls1.contains(nums1[i])) ls1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(!hs1.contains(nums2[i])) if(!ls2.contains(nums2[i])) ls2.add(nums2[i]);
        }
        adj.add(new ArrayList<>(ls1));
        adj.add(new ArrayList<>(ls2));
        return adj;
    }
}