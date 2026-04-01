class NumMatrix {

    int[][] sum;
    int row = 0;
    int col = 0;

    public NumMatrix(int[][] matrix) {
        sum = matrix;
        row = matrix.length;
        col = matrix[0].length;
        for (int r = 0; r < row; r++) {
            for (int c = 1; c < col; c++) {
                sum[r][c] += sum[r][c - 1];
            }
        }
        for (int r = 1; r < row; r++) {
            for (int c = 0; c < col; c++) {
                sum[r][c] += sum[r - 1][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = sum[row2][col2];
        int above = (row1 > 0) ? sum[row1 - 1][col2] : 0;
        int left = (col1 > 0) ? sum[row2][col1 - 1] : 0;
        int aboveLeft = (row1 > 0 && col1 > 0) ? sum[row1 - 1][col1 - 1] : 0;

        return total - above - left + aboveLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */