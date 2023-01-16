class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int s=newInterval[0];
        int e=newInterval[1];
        int[] vis=new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            if((intervals[i][0]<=e && intervals[i][0]>=s)||(intervals[i][1]<=e && intervals[i][1]>=s)
              ||(intervals[i][0]<=s && intervals[i][1]>=s)|| (intervals[i][0]<=e && intervals[i][1]>=e)){
                vis[i]=1;
            }
        }
        List<int[]> ans = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            if(vis[i]==1){
                s=Math.min(s,intervals[i][0]);
                e=Math.max(e,intervals[i][1]);
            }
            else{
                ans.add(new int[]{intervals[i][0],intervals[i][1]});
            }
        }
        ans.add(new int[]{s,e});
        int[][] dim=ans.toArray(new int[0][]);
        Arrays.sort(dim,(a,b)->
            a[0]-b[0]
        );
        return dim;
    }
}