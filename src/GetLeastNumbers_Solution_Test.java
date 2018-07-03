/*
输入n个整数，找出其中最小的K个数。
例如输入4,5,1,6,2,7,3,8这8个数字，
则最小的4个数字是1,2,3,4,。
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GetLeastNumbers_Solution_Test {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(k <= 0 || k > input.length) return list;
        if(k == input.length){
            for (int i = 0; i < input.length; i++) {
                list.add(input[i]);
            }
            Collections.sort(list);
            return list;
        }
        int start = 0, end = input.length - 1;
        int num = partition(input , input.length , start, end);
        while(num != k && num != k - 1){
            if(num > k){
                end = num - 1;
                num = partition(input , input.length , start, end);
            }
            if(num < k){
                start = num + 1;
                num = partition(input , input.length , start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        Collections.sort(list);
        return list;

    }

    private int partition(int[] input, int length, int start, int end) {
        if(start < 0 || end >= input.length || input ==null || length <=0) new RuntimeException("超出范围");
        int index = new Random().nextInt(end) % (end - start + 1) + start;
        swap(input,index,end);
        int small=start-1;
        for (index = start; index < end; index++) {
            if(input[index] < input[end]){
                small++;
                if(small != index) swap(input, index, small);
            }
        }
        small++;
        swap(input, small, end);
        return small;
    }

    private void swap(int[] input, int a, int b) {
        int temp=input[a];
        input[a]=input[b];
        input[b]=temp;
    }

    public static void main(String[] args) {
        GetLeastNumbers_Solution_Test test=new GetLeastNumbers_Solution_Test();
        int [] in=new int[]{1,2,3,2,5};
        System.out.println(test.GetLeastNumbers_Solution(in,3));
    }
}
