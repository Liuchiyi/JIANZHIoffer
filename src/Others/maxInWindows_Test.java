package Others;

import java.util.ArrayList;

public class maxInWindows_Test {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> resList = new ArrayList<>();
        if(size == 0) return resList;
        int max = 0, windowsIn = size - 1 , windowsOut = -1;
        if(num.length < size) return resList;
        if(windowsIn < num.length) {
            windowsOut++;
            windowsIn++;
            max = FindMax(num,windowsOut,windowsIn);
            resList.add(max);
        }
        while (windowsIn < num.length){
            if(num[windowsIn] >= max){
                max = num[windowsIn];
                resList.add(max);
                windowsOut++;
                windowsIn++;
                continue;
            }
            if(num[windowsOut] != max ){
                resList.add(max);
                windowsOut++;
                windowsIn++;
                continue;
            }
            windowsOut++;
            windowsIn++;
            max = FindMax(num,windowsOut,windowsIn);
            resList.add(max);
        }
        return resList;
    }

    private int FindMax(int[] num, int windowsOut, int windowsIn) {
        int currentMax = num[windowsOut];
        for (int i = windowsOut + 1; i < windowsIn; i++) {
            if(num[i] > currentMax) currentMax = num[i];
        }
        return currentMax;
    }

    public static void main(String[] args) {
        int [] num = new int[]{2,3,4,2,6,2,5,1};
        maxInWindows_Test test = new maxInWindows_Test();
        System.out.println(test.maxInWindows(num,0));
    }
}
