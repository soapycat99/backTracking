package backTracking;

public class SudokuSol {

    public static void main(String[] args) {
        int [][] matrix = new int[][]
                {
                        { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                        { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                        { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                        { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                        { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                        { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                        { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
                };

        if(SolveSuduko(matrix, 9)){
        	printMatrix(matrix);
        }

    }
    
	public static void printMatrix(int matrix[][]) {
		for (int i=0; i<9;i++) {
			System.out.println();
			for(int j=0; j<9;j++) {
				if(j!=8)
					System.out.print(matrix[i][j] + " |");
				else
					System.out.print(matrix[i][j]);
			}
		}
	}

    public static boolean SolveSuduko(int [][]matrix, int n){
        int rowIndex = -1;
        int columnIndex = -1;
        int i = 0;
        int j = 0;

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    rowIndex = i;
                    columnIndex = j;
                    break;
                }
            }
            if(rowIndex != -1){
                break;
            }

        }
        if(i == n && j == n){
            return  true;
        }
        else {
            for (int value = 1; value < 10; value++) {
                if(IsSafe(matrix, value, rowIndex, columnIndex, n)){
                    matrix[rowIndex][columnIndex] = value;
                    if(!SolveSuduko(matrix,n)){
                        matrix[rowIndex][columnIndex] = 0;
                    }
                    else {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static boolean IsSafe(int [][] matrix, int value, int rowIndex, int columnIndex, int n){
        //row check
        for (int j = 0; j < 9; j++) {
            if(matrix[rowIndex][j] == value){
                return  false;
            }
        }
        //column check
        for (int i = 0; i < 9; i++) {
            if(matrix[i][columnIndex] == value){
                return  false;
            }
        }
        //submatrix check
        int baseRowIndex = rowIndex - (rowIndex % 3);
        int baseColumnIndex = columnIndex - (columnIndex % 3);
        for (int i = baseRowIndex; i < baseRowIndex + 3; i++) {
            for (int j = baseColumnIndex; j < baseColumnIndex + 3; j++) {
                if(matrix[i][j] == value){
                    return  false;
                }

            }
        }
        return true;
    }
}
