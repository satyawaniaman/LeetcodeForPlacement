class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> li=new ArrayList<Integer>();
        int startCol=0;
        int startRow=0;
        int endCol=matrix[0].length-1;
        int endRow=matrix.length-1;
        while(startCol<=endCol && startRow<=endRow) {
        	for(int j=startCol;j<=endCol;j++) { //top
        		li.add(matrix[startRow][j]);
        	}
        	for(int i=startRow+1;i<=endRow;i++) { //right
        		li.add(matrix[i][endCol]);
        	}
        	for(int j=endCol-1;j>=startCol;j--) { //bottom
        		if(startRow==endRow) {
        			break;
        		}
        		li.add(matrix[endRow][j]);
        	}
        	for(int i=endRow-1;i>startRow;i--) { //left
        		if(startCol==endCol) {
        			break;
        		}
        		li.add(matrix[i][startCol]);
        	}
        	startCol++;
        	startRow++;
        	endRow--;
        	endCol--;
        	
        }
        return li;
    }
}