/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */


public class duplicate_Test {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length <= 0 || numbers == null){
            return false;
        }
        for (int i = 0; i < length; i++) {
            while( numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers,numbers[i],i);
            }
        }
        return false;
    }

    private void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

    public static void main(String[] args) {
        duplicate_Test test = new duplicate_Test();
        int [] num = new int[]{1,2,3,5,7,4,2,0};
        int len = num.length;
        int [] duplication = new int[1];
        System.out.println(test.duplicate(num,len,duplication));
        System.out.println(duplication[0]);

    }
}
