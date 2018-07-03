package Others;

import java.util.PriorityQueue;


public class GetMedian_Test {

    PriorityQueue<Integer> minStack = new PriorityQueue<>();
    PriorityQueue<Integer> maxStack = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public void Insert(Integer num) {
        if(maxStack.size() == 0 && minStack.size() == 0){
            maxStack.add(num);
            return;
        }
        if(num > maxStack.peek()){
            minStack.add(num);
        }else {
            maxStack.add(num);
        }
        if(maxStack.size() - minStack.size() > 1){
            minStack.add(maxStack.poll());
            return;
        }
        if(minStack.size() - maxStack.size() > 0){
            maxStack.add(minStack.poll());
            return;
        }
    }

    public Double GetMedian() {
        if(maxStack.size() == 0 && minStack.size() == 0){
            return null;
        }
        if(maxStack.size() == minStack.size()){
            return (minStack.peek() + maxStack.peek()) / 2.0;
        }else return (double)maxStack.peek();
    }

    public static void main(String[] args) {
        GetMedian_Test test = new GetMedian_Test();
        test.Insert(2);
        test.Insert(9);
        test.Insert(3);
        test.Insert(5);
        test.Insert(7);
        test.Insert(1);
        System.out.println(test.GetMedian());
    }

}
