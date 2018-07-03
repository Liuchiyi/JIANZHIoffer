package Others;

import java.util.PriorityQueue;


public class GetMedian_Test2 {

    int count = 0;
    PriorityQueue<Integer> maxStack = new PriorityQueue<>();
    PriorityQueue<Integer> minStack = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public void Insert(Integer num) {
        if((count & 1) == 0){
            maxStack.add(num);
            minStack.add(maxStack.poll());
            count++;
            return;
        }else {
            minStack.add(num);
            maxStack.add(minStack.poll());
            count++;
            return;
        }
    }

    public Double GetMedian() {
        if((count & 1) == 1)
            return (double) minStack.peek();
        else
            return (maxStack.peek() + minStack.peek())/2.0;
    }

    public static void main(String[] args) {
        GetMedian_Test2 test = new GetMedian_Test2();
        test.Insert(2);
        test.Insert(9);
        test.Insert(3);
        test.Insert(5);
        test.Insert(7);
        System.out.println(test.GetMedian());
    }

}
