/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
*/

public class VerifySquenceOfBST_Test2 {

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0) return false;
        if(sequence.length==1) return  true;
        return VerifySquenceListOfBST(sequence,0,sequence.length-1);
    }

    private static boolean VerifySquenceListOfBST(int [] sequence,int start,int end) {
        if(start>=end) return true;
        int leftstart=start;
        int leftend=start;
        int rightstart=end-1;
        int rightend=end-1;
        while(leftend<=end&&sequence[leftend]<sequence[end]) leftend++;
        while(rightstart>=start&&sequence[rightstart]>sequence[end]) rightstart--;
        if(rightstart!=leftend-1) return false;//leftend-1  +1  ！=rightstart+1  +1
        return VerifySquenceListOfBST(sequence,leftstart,leftend-1)&&VerifySquenceListOfBST(sequence,rightstart+1,rightend);
        //leftend多加一次，rightstart多减一次(目的是为了防止数组出界)
    }

    public static void main(String[] args) {
        int [] test={5,4,3,2,1};
        System.out.println(VerifySquenceOfBST(test));

    }
}
