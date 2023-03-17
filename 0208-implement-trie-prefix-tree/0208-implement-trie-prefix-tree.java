class Trie {
    HashSet<String> hs;
    public Trie() {
        hs=new HashSet<>();
        
    }
    
    public void insert(String word) {
        hs.add(word);
    }
    
    public boolean search(String word) {
        return hs.contains(word);
    }
    
    public boolean startsWith(String prefix) {
        Iterator<String> it=hs.iterator();
        int len=prefix.length();
        while(it.hasNext()){
            String str=it.next();
            if(str.length()>=len){
                if(str.substring(0,len).equals(prefix)) return true;
            }
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
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