/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
 * 他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,
 * 你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 输出所有和为S的连续正数序列。
 * 序列内按照从小至大的顺序，
 * 序列间按照开始数字从小到大的顺序
 */

import java.util.ArrayList;

/**
 * 根据数学公式计算:(a1+an)*n/2=s  n=an-a1+1
 * (an+a1)*(an-a1+1)=2*s=k*l(k>l)
 * an=(k+l-1)/2  a1=(k-l+1)/2
 */


public class FindContinuousSequence_Test2 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        if(sum < 3) return resList;
        int mid = (int) Math.sqrt(sum * 2);
        for (int l = mid; l >= 2; l--) {
            if((sum * 2 % l) == 0){
                int k = sum * 2 / l;
                if(((k & 1) == 0 && (l & 1) == 1) || ((k & 1) == 1 && (l & 1) == 0)){
                    int a1 = ( k - l + 1) / 2;
                    int an = ( k + l - 1) / 2;
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int i = a1; i <= an; i++) {
                        list.add(i);
                    }
                    resList.add(list);
                }
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        FindContinuousSequence_Test2 test = new FindContinuousSequence_Test2();
        ArrayList<ArrayList<Integer>> testList = new ArrayList<>();
        testList=test.FindContinuousSequence(3);
        System.out.println(testList);
    }
}
