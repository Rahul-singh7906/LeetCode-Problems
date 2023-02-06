class Solution {
    public int leastInterval(char[] tasks, int n) {
        char[] freq=new char[26];
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }
        Arrays.sort(freq);
        int box=freq[25]-1;
        int total=box*(n);
        for(int i=24;i>=0;i--){
            total-=Math.min(freq[i],box);
        }
        return total>0?total+tasks.length:tasks.length;
    }
}