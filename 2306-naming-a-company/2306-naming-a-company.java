class Solution {
    public long distinctNames(String[] ideas) {
        HashMap<Integer,HashSet<String>>  hm = new HashMap<>();
        for(int i=0;i<ideas.length;i++){
            int ind=ideas[i].charAt(0)-'a';
            if(!hm.containsKey(ind)) hm.put(ind,new HashSet<>());
            hm.get(ind).add(ideas[i].substring(1));
        }
        long ans=0;
        for(int i=0;i<25;i++){
            for(int j=i+1;j<26;j++){
                int temp=0;
                if(hm.get(i)!=null && hm.get(j)!=null){
                    for(String s:hm.get(i)){
                        if(hm.get(j).contains(s)) temp++;
                    }
                    int val=2*(hm.get(i).size()-temp)*(hm.get(j).size()-temp);
                    ans+=val;
                }
            }
        }
        return ans;
    }
}