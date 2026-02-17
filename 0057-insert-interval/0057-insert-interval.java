class Solution {
    public int[][] insert(int[][] intervals, int[] new_int) {
       if(intervals.length == 0) return new int[][]{new_int};
        int left = 0;
        int right = intervals.length-1;
        int inidx = intervals.length;
        while(left <= right){
            int mid = (left+right)/2;
            if(intervals[mid][1]>=new_int[0]){
                inidx = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        ArrayList<int[]> lst = new ArrayList<>();

        for(int i=0; i<inidx; i++){
            lst.add(intervals[i]);
        }

        int s = new_int[0];
        int e = new_int[1];
        int c = inidx;
        int n = intervals.length;

        while(c<n && intervals[c][0]<=e){
            s = Math.min(s, intervals[c][0]);
            e = Math.max(e, intervals[c][1]);
            c++;
        }
        lst.add(new int[]{s,e});
        for(int i=c; i<n; i++){
            lst.add(intervals[i]);
        }

        return lst.toArray(new int[lst.size()][]); 
    }
}