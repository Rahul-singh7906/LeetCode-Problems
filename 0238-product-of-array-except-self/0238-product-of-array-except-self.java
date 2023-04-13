class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix=new int[nums.length];
        int m1=1;
        int postfix[]=new int[nums.length];
        int m2=1;
        int n=nums.length-1;
        prefix[0]=1;
        postfix[n]=1;
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]*nums[i-1];
        }
        for(int i=n-1;i>=0;i--){
            postfix[i]=postfix[i+1]*nums[i+1];
        }
        int[] ans=new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i]=prefix[i]*postfix[i];
        }
        return ans;
    }
}