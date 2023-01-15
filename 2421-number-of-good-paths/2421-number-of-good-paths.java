class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n ; i++)graph[i] = new ArrayList<>();
        for(int[] e: edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        TreeMap<Integer,List<Integer>> valueToNodes = new TreeMap<>();
        for(int i = 0; i < n ; i++){
            valueToNodes.computeIfAbsent(vals[i] , value -> new ArrayList<>()).add(i);
        }

        UnionFind dsu = new UnionFind(n);
        int ans = 0;
        for(int v : valueToNodes.keySet()){

            for(int node : valueToNodes.get(v)){

                for(int nbr : graph[node]){
                    if(vals[nbr] <= vals[node]){
                        dsu.union_set(node,nbr);
                    }
                }
            }

            Map<Integer,Integer> comps_size = new HashMap<>();
            for(int node : valueToNodes.get(v)){
                comps_size.put(dsu.find(node),comps_size.getOrDefault(dsu.find(node) , 0)+1);
            }
            for(int c : comps_size.keySet()){
                int size = comps_size.get(c);
                ans += size*(size+1)/2;
            }
        }
        return ans;
    }
}
class UnionFind {
    int[] parent;
    int[] rank;
    public UnionFind(int n){
        this.parent = new int[n];
        for(int i = 0; i < n ; i++)parent[i] = i;
        rank = new int[n];
    }

    public int find(int i){
        if(parent[i] == i)return i;
        return parent[i] = find(parent[i]);
    }

    public void union_set(int x , int y){
        int xset = find(x) , yset = find(y);
        if(xset == yset)return;
        if(rank[xset] < rank[yset]){
            parent[xset] = yset;
        }else if(rank[yset] < rank[xset]){
            parent[yset] = xset;
        }else{
            parent[xset] = yset;
            rank[xset]++;
        }
    }
}