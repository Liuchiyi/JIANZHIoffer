import java.util.ArrayList;

/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
*/

public class VerifySquenceOfBST_Test {

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0) return  true;
        ArrayList sequenceList=new ArrayList();
        for (int i = 0; i < sequence.length; i++) {
            sequenceList.add(sequence[i]);
        }
        return VerifySquenceListOfBST(sequenceList);
    }

    private static boolean VerifySquenceListOfBST(ArrayList<Integer> sequenceList) {
        if(sequenceList.isEmpty()) return true;
        ArrayList<Integer> leftsequenceList=new ArrayList<>();
        ArrayList<Integer> rightsequenceList=new ArrayList<>();
        int length=sequenceList.size();
        int currentNum=0;
        int currentVal;
        int rootVal=sequenceList.get(length-1);
        boolean result=false;
        while((currentVal=sequenceList.get(currentNum))<rootVal){
            leftsequenceList.add(currentVal);
            currentNum++;
        }
        while((currentVal=sequenceList.get(currentNum))>rootVal){
            rightsequenceList.add(currentVal);
            currentNum++;
        }
        if(currentNum!=length-1) return false;
        if(VerifySquenceListOfBST(leftsequenceList)) result=true;
        if(VerifySquenceListOfBST(rightsequenceList)) result=true;
        return result;
    }

    public static void main(String[] args) {
        int [] test={1};
        System.out.println(VerifySquenceOfBST(test));

    }
}
