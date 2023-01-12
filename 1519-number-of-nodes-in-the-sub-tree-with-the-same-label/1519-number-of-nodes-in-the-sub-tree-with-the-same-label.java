class Solution {
    int[] bvis;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        bvis=new int[n];
        dfs(0,adj,-1,labels);
        return bvis;
    }
    public int[] dfs(int i,List<List<Integer>> adj,int par,String labels){
        int[] curSubTree=new int[26];
        for(int it:adj.get(i)){
            if(par!=it){
                int[] childSubTree=dfs(it,adj,i,labels);
                for (int j = 0; j < 26; j++) {      
                    curSubTree[j] += childSubTree[j];
                }
            }
        }
        curSubTree[labels.charAt(i)-'a']++;
        bvis[i]=curSubTree[labels.charAt(i)-'a'];
        return curSubTree;
    }
}