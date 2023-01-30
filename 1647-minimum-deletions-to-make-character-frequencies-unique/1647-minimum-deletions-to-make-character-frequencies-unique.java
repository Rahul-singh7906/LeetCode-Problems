class Solution {
    public int minDeletions(String s) {
       int[] ch=new int[26];
        for(char c:s.toCharArray()){
            ch[c-'a']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int it:ch){
            if(it>0) pq.add(it);
        }
        int ct=0;
        while(!pq.isEmpty()){
            int freq=pq.poll();
            if(pq.size()==0) return ct;
            if(freq==pq.peek()){
                if(freq>1) {
                    pq.add(freq-1);
                }
                ct++;
            }
        }
        return ct;
    }
}