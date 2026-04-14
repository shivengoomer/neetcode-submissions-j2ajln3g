class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start=0;
        int col=matrix[0].length-1;
        int i=0;
        for(i=0;i<matrix.length;i++){
            if(matrix[i][0]<=target && matrix[i][matrix[0].length-1]>=target) break;
        }
        if (i == matrix.length) return false;
        while(start<=col){
            int mid=(col+start)/2;
            if(matrix[i][mid]==target) return true;
            else if (matrix[i][mid]<target) start=mid+1;
            else{
                col=mid-1;
            }
        }
        return false;
    }
}