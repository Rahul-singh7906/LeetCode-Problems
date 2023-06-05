class Solution {
    public boolean checkStraightLine(int[][] c) {
        int dx=getX(c[1],c[0]);
        int dy=getY(c[1],c[0]);
        for(int i=2;i<c.length;i++){
            if(dy*getX(c[i],c[0])!=dx*getY(c[i],c[0])) return false;
        }
        return true;
    }
    public int getX(int[] a,int[] b){
        return a[0]-b[0];
    }
    public int getY(int[] a,int[] b){
        return a[1]-b[1];
    }
    
}