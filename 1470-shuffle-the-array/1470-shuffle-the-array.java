class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr=new int[(nums.length)];
        int s1=0;
        int e1=(nums.length/2)-1;
        int s2=nums.length/2;
        int ind=0;
        while(ind<nums.length){
            arr[ind]=nums[s1];
            ind+=1;
            s1+=1;
            arr[ind]=nums[s2];
            ind+=1;
            s2+=1;
        }
        return arr;
    }
}