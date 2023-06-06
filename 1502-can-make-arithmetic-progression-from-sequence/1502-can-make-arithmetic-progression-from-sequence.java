class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d=arr[1]-arr[0];
        for(int i=1;i<arr.length;i++){
            int temp=arr[i]-arr[i-1];
            if(temp!=d) return false;
        }
        return true;
    }
}