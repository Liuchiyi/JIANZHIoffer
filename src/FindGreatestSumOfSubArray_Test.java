
/*
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
今天测试组开完会后,他又发话了:在古老的一维模式识别中,
常常需要计算连续子向量的最大和,当向量全为正数的时候,
问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
连续子向量的最大和为8(从第0个开始,到第3个为止)。
你会不会被他忽悠住？(子向量的长度至少是1)
*/

public class FindGreatestSumOfSubArray_Test {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 1) return array[0];
        int result = array[0];
        int current = array[0];
        for (int i = 1; i < array.length; i++) {
            if(current < 0 ){
                if(current < array[i]) result = array[i];
                current = 0;
            }
            if(array[i - 1] >= 0 && array[i] < 0){
                if(current > result) result = current;
            }
            current = current + array[i];
        }
        return result > current ? result : current;
    }

    public static void main(String[] args) {
        FindGreatestSumOfSubArray_Test test = new FindGreatestSumOfSubArray_Test();
        int [] in =new int[]{-2,-8,-1,-5,-9};
        System.out.println(test.FindGreatestSumOfSubArray(in));
    }
}
