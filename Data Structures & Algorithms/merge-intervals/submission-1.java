class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> temp = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        temp.add(new int[]{intervals[0][0],intervals[0][1]});
        int idx=0;
        for(int i=1;i<intervals.length;i++){
            int[] past= temp.get(idx);
            if(intervals[i][0] <= past[1]){
                temp.get(idx)[0]=Math.min(temp.get(idx)[0],intervals[i][0]);
                temp.get(idx)[1]=Math.max(temp.get(idx)[1],intervals[i][1]);
            }
            else{
                temp.add(new int[]{intervals[i][0],intervals[i][1]});
                idx++;
            }
        }
        int[][] res= new int[temp.size()][2];
        idx=0;
        for(int[] i:temp){
            res[idx++]=i;
        }
        return res;
    }
}
