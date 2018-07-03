package Others;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class maxInWindows_Test2 {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> resList = new ArrayList<>();
        if(size == 0) return resList;
        if(size > num.length) return resList;
        int begin = 0;
        ArrayDeque<Integer> listHelper = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            begin = i - (size - 1);
            if(listHelper.isEmpty())
                listHelper.add(i);
            else if(begin > listHelper.peekFirst())
                listHelper.pollFirst();
            while (!listHelper.isEmpty() && num[listHelper.peekLast()] <= num[i])
                listHelper.pollLast();
            listHelper.add(i);
            if(begin >= 0)
                resList.add(num[listHelper.peekFirst()]);
        }
        return resList;
    }


    public static void main(String[] args) {
        int [] num = new int[]{2,3,4,2,6,2,5,1};
        maxInWindows_Test2 test = new maxInWindows_Test2();
        System.out.println(test.maxInWindows(num,3));
    }
}
