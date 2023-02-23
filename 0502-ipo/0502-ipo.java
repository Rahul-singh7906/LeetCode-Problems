class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] arr=new int[profits.length][2];
        for(int i=0;i<profits.length;i++){
            arr[i][0]=profits[i];
            arr[i][1]=capital[i];
        }
        Arrays.sort(arr,(a,b)->
             a[1]-b[1]
        );
        // for(int i=0;i<profits.length;i++){
        //     System.out.println(arr[i][0]+" "+arr[i][1]);
        // }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ind=0;
        while(k-->0){
            while(ind<profits.length && arr[ind][1]<=w){
                pq.add(arr[ind][0]);
                ind++;
            }
            if(pq.isEmpty()) break;
            w+=pq.poll();
        }
        return w;
    }
}