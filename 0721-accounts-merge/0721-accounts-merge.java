class Disjoint{
    int[] parent;
    int[] size;
    Disjoint(int n){
        parent=new int[n+1];
        size=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public int findPar(int node){
        if(parent[node]==node) return node;
        return parent[node]=findPar(parent[node]);
    }
    public void union(int u,int v){
        int ulp_u=findPar(u);
        int ulp_v=findPar(v);
        if(ulp_u==ulp_v) return;
        if(size[ulp_u]<size[ulp_v]){
            parent[ulp_u]=ulp_v;
            size[ulp_v]+=size[ulp_u];
        }
        else{
            parent[ulp_v]=ulp_u;
            size[ulp_u]+=size[ulp_v];
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> acc) {
        int n=acc.size();
        Disjoint ds=new Disjoint(n);
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0;i<acc.size();i++){
            for(int j=1;j<acc.get(i).size();j++){
                String str=acc.get(i).get(j);
                if(!hm.containsKey(str)) hm.put(str,i);
                else {
                    ds.union(i,hm.get(str));
                }
            }
        }
        ArrayList<String>[] mergedMail=new ArrayList[n];
        for(int i=0;i<n;i++){
            mergedMail[i]=new ArrayList<String>();
        }
        for(Map.Entry<String,Integer> it:hm.entrySet()){
            String mail=it.getKey();
            int node=ds.findPar(it.getValue());
            mergedMail[node].add(mail);
        }
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mergedMail[i].size()==0) continue;
            List<String> ls=new ArrayList<>();
            Collections.sort(mergedMail[i]);
            ls.add(acc.get(i).get(0));
            for(String it:mergedMail[i]){
                ls.add(it);
            }
            ans.add(ls);
        }
        return ans;
    }
}