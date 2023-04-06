//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

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
    public void unionBySize(int u,int v){
        int ulp_u=findPar(u);
        int ulp_v=findPar(v);
        if(ulp_u==ulp_v){
            return;
        }
        if(size[ulp_u]>size[ulp_v]){
            parent[ulp_v]=ulp_u;
            size[ulp_u]+=size[ulp_v];
        }
        else{
            parent[ulp_u]=ulp_v;
            size[ulp_v]+=size[ulp_u];
        }
    }
}
class Solution {
    public int Solve(int n, int[][] edge) {
        Disjoint ds=new Disjoint(n);
        int extra=0;
        for(int i=0;i<edge.length;i++){
            if(ds.findPar(edge[i][0])==ds.findPar(edge[i][1])) extra++;
            else ds.unionBySize(edge[i][0],edge[i][1]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(ds.parent[i]==i) ans++;
        }
        ans-=1;
        if(extra>=ans) return ans;
        return -1;
    }
}