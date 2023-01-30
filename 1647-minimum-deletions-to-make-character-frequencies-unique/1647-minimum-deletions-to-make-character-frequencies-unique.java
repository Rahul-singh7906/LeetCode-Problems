class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(char it:hm.keySet()){
            pq.add(hm.get(it));
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