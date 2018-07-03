package Others;

public class movingCount_Test {
    int Num = 0;
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean [][] booleans = new boolean[rows][cols];
        countHelper(threshold,rows,cols,0,0,booleans);
        return Num;
    }

    private void countHelper(int threshold, int rows, int cols, int crows, int ccols, boolean[][] booleans) {
        if(crows < 0 || ccols < 0 || crows >= rows || ccols >= cols || booleans[crows][ccols])
            return;
        int sum = 0;
        int sum1 = crows,sum2 = ccols;
        while (sum1 !=0){
            sum += sum1 % 10;
            sum1 = sum1 / 10;
        }
        while (sum2 !=0){
            sum += sum2 % 10;
            sum2 = sum2 / 10;
        }
        if(sum <= threshold) Num++;
        else return;
        booleans[crows][ccols] = true;
        countHelper(threshold,rows,cols,crows-1,ccols,booleans);
        countHelper(threshold,rows,cols,crows+1,ccols,booleans);
        countHelper(threshold,rows,cols,crows,ccols-1,booleans);
        countHelper(threshold,rows,cols,crows,ccols+1,booleans);
    }

    public static void main(String[] args) {
        movingCount_Test test = new movingCount_Test();
        System.out.println(test.movingCount(10,1,100));
    }
}
