class Solution {
    public void rotate(int[][] matrix) {
        for (int col = 0; col < matrix.length; col++) {
            int i = 0;
            int j = matrix.length-1;
            while(i<=j){
                int temp = matrix[i][col];
                matrix[i][col] = matrix[j][col];
                matrix[j][col] = temp;
                i++;
                j--;
            }
        }
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = i+1; j < matrix[0].length; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
}