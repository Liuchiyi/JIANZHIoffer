import java.util.ArrayList;

/*
        输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
        例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
        则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
*/
public class printMatrix_Test {

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        int xend=matrix[0].length-1;
        int yend=matrix.length-1;
        int xbegin=0;
        int ybegin=0;
        ArrayList list=new ArrayList();
        while(xbegin<=xend&&ybegin<=yend){
            list.addAll(printCircle(matrix,xbegin,xend,ybegin,yend));
            xbegin++;
            ybegin++;
            xend--;
            yend--;
        }
        return list;
    }
    public static ArrayList<Integer> printCircle(int[][] matrix, int xbegin, int xend, int ybegin, int yend){
        ArrayList smallList=new ArrayList();
        for (int i = xbegin; i <=xend; i++) {
            smallList.add(matrix[ybegin][i]);
        }
        for (int j = ybegin+1; j <=yend; j++) {
            smallList.add(matrix[j][xend]);
        }
        if(ybegin<yend) {
            for (int m = xend - 1; m >= xbegin; m--) {
                smallList.add(matrix[yend][m]);
            }
        }
        if(xbegin<xend) {
            for (int n = yend - 1; n > ybegin; n--) {
                smallList.add(matrix[n][xbegin]);
            }
        }
        return smallList;
    }

    public static void main(String[] args) {
        ArrayList listresult;
        int [] [] matrx=new int[3][4];
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 4; j++) {
                matrx[i][j] = i + j;
            }
        }
        listresult=printMatrix(matrx);
        System.out.println(listresult.size());
    }
}
