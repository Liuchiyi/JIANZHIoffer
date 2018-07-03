package Others;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * 所谓的回溯无非就是对使用过的字符进行标记后和处理后的去标记
 * 改进点：不变成二维数组，直接用下标进行计算
 */

public class hasPath_Test2 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(str.length == 0 || matrix.length ==0) return false;
        boolean [] booleanMatrix = new  boolean[matrix.length];
        for (int a = 0; a < rows; a++) {
            for (int b = 0; b < cols; b++) {
                if(hasPathHelper(matrix,rows,cols,str,0,a,b,booleanMatrix))
                    return true;
            }
        }
        return false;
    }

    private boolean hasPathHelper(char[] matrix, int rows, int cols, char[] str, int strNum, int crows, int ccols, boolean[] booleanMatrix) {
        if(strNum >= str.length) return true;
        if(crows < 0 || ccols < 0 || crows >= rows || ccols >= cols || booleanMatrix[crows * cols + ccols] || str[strNum] != matrix[crows * cols + ccols])
            return false;
        booleanMatrix[crows * cols + ccols] = true;
        if(     hasPathHelper(matrix,rows,cols,str,strNum + 1,crows-1,ccols,booleanMatrix)||
                hasPathHelper(matrix,rows,cols,str,strNum + 1,crows+1,ccols,booleanMatrix)||
                hasPathHelper(matrix,rows,cols,str,strNum + 1,crows,ccols-1,booleanMatrix)||
                hasPathHelper(matrix,rows,cols,str,strNum + 1,crows,ccols+1,booleanMatrix))
            return true;
        booleanMatrix[crows * cols + ccols] = false;
        return false;
    }



    public static void main(String[] args) {
        hasPath_Test2 test = new hasPath_Test2();
        char [] cc = new char[]{'a','b','c','e','s','f','c','s','a','d','e','e'};
        char [] dd = new char[]{'b','c','c','f','b'};
        System.out.println(test.hasPath(cc,3,4,dd));
    }

}
