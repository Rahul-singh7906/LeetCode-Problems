class WordDictionary {
    private class Node{
        Node[] child;
        boolean isEnd;
        Node(){
            child=new Node[26];
        }
            public boolean find(String word,int i){
            if(i==word.length()) return isEnd;
            char ch=word.charAt(i);
            if(word.charAt(i)=='.'){
                for(Node cd:child){
                    if(cd!=null && cd.find(word,i+1)) return true;
                }
                return false;
            }
            else{
                if(child[ch-'a']==null) return false;
                else{
                    return child[ch-'a'].find(word,i+1);
                }
            }
        }
    }
    final private Node root;
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.child[ch-'a']==null){
                curr.child[ch-'a']=new Node();
            }
            curr=curr.child[ch-'a'];
        }
        curr.isEnd=true;
    }
    
    public boolean search(String word) {
        return root.find(word,0);
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// Iterator<Integer> it = set.iterator();
  
//         System.out.println(
//             "Iterate HashSet using iterator : ");
  
//         // Iterate HashSet with the help of hasNext() and
//         // next() method
//         while (it.hasNext()) {
  
//             // Print HashSet values
//             System.out.print(it.next() + " ");
//         }