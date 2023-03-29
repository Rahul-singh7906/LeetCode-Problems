//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static HashSet<String> hs;
    public static int wordBreak(String A, ArrayList<String> B )
    {
        hs=new HashSet<>();
        for(int i=0;i<B.size();i++){
            hs.add(B.get(i));
        }
        return isValid(A)?1:0;
    }
    public static boolean isValid(String s){
        if(s.length()==0) return true;
        for(int i=1;i<=s.length();i++){
            if(hs.contains(s.substring(0,i)) && isValid(s.substring(i,s.length()))) return true;

        }
        return false;
    }
}