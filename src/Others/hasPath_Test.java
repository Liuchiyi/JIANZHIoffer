package Others;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * 所谓的回溯无非就是对使用过的字符进行标记后和处理后的去标记
 */

public class hasPath_Test {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(str.length == 0 || matrix.length ==0) return false;
        char [][] realMatrix = new char[rows][cols];
        boolean [][] booleanMatrix = new  boolean[rows][cols];
        int prows, pcols;
        for (int i = 0; i < matrix.length ; i++) {
            prows = i / cols;
            pcols = i % cols;
            realMatrix[prows][pcols] = matrix[i];
        }
        for (int a = 0; a < rows; a++) {
            for (int b = 0; b < cols; b++) {
                if(str[0] == realMatrix[a][b]){
                    booleanMatrix[a][b] = true;
                    if(hasPathHelper(realMatrix, rows, cols, str, 1, a, b,booleanMatrix))
                        return true;
                    booleanMatrix[a][b] = false;
                }

            }
        }
        return false;
    }

    private boolean hasPathHelper(char[][] realMatrix, int rows, int cols, char[] str, int num, int crows, int ccols, boolean[][] booleanMatrix) {
        if (num >= str.length) return true;
        if ( ccols - 1 >= 0 && !booleanMatrix[crows][ccols-1] && realMatrix[crows][ccols-1] == str[num]){
            booleanMatrix[crows][ccols-1] = true;
            if(hasPathHelper(realMatrix,rows,cols,str,num + 1,crows,ccols-1,booleanMatrix))
                return true;
            booleanMatrix[crows][ccols-1] = false;
        }
        if ( ccols + 1 <cols && !booleanMatrix[crows][ccols+1] && realMatrix[crows][ccols+1] == str[num]){
            booleanMatrix[crows][ccols+1] = true;
            if(hasPathHelper(realMatrix,rows,cols,str,num + 1,crows,ccols+1,booleanMatrix))
                return true;
            booleanMatrix[crows][ccols+1] = false;
        }
        if ( crows - 1 >= 0 && !booleanMatrix[crows - 1][ccols] && realMatrix[crows - 1][ccols] == str[num]){
            booleanMatrix[crows - 1][ccols] = true;
            if(hasPathHelper(realMatrix,rows,cols,str,num + 1,crows - 1,ccols,booleanMatrix))
                return true;
            booleanMatrix[crows - 1][ccols] = false;
        }
        if ( crows + 1 < rows && !booleanMatrix[crows + 1][ccols] && realMatrix[crows + 1][ccols] == str[num]){
            booleanMatrix[crows + 1][ccols] = true;
            if(hasPathHelper(realMatrix,rows,cols,str,num + 1,crows + 1,ccols,booleanMatrix))
                return true;
            booleanMatrix[crows + 1][ccols] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        hasPath_Test test = new hasPath_Test();
        char [] cc = new char[]{'a','b','c','e','s','f','c','s','a','d','e','e'};
        char [] dd = new char[]{'b','c','c','f'};
        System.out.println(test.hasPath(cc,3,4,dd));
    }

}
