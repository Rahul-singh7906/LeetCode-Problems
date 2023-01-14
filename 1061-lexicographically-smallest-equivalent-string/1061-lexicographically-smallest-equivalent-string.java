class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<26;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<s1.length();i++){
            int v1=s1.charAt(i)-'a';
            int v2=s2.charAt(i)-'a';
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }
        String str="";
        for(int i=0;i<baseStr.length();i++){
            char[] ch=new char[1];
            ch[0]=baseStr.charAt(i);
            int v=ch[0]-'a';
            dfs(v,adj,ch,new int[26]);
            str+=ch[0];
        }
        return str;
    }
    public void dfs(int v,List<List<Integer>> adj,char[] ch,int[] vis){
        vis[v]=1;
        for(int it:adj.get(v)){
            char c=(char)(it+97);
            if(c<ch[0]){
                ch[0]=c;
            }
            if(vis[it]==0) dfs(it,adj,ch,vis);
        }
    }
}