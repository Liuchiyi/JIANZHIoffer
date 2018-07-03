
import java.util.HashSet;
import java.util.Iterator;

/**
 * 一个整型数组里除了两个数字之外，
 * 其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */

public class FindNumsAppearOnce_Test {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if(!set.add(array[i])) set.remove(array[i]);
        }
        Iterator iterator=set.iterator();
        if (iterator.hasNext()) num1[0] = (int)iterator.next();
        if (iterator.hasNext()) num2[0] = (int)iterator.next();
    }

    public static void main(String[] args) {
        int [] array = new int[]{1,2,3,4,5,6,7,8,7,6,5,4,3,2};
        int num1[] = new int[1];
        int num2[] = new  int[1];
        FindNumsAppearOnce_Test test = new FindNumsAppearOnce_Test();
        test.FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

}
