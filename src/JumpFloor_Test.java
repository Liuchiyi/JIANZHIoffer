
/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
*/

public class JumpFloor_Test {
    public static int JumpFloor(int target) {
        if (target <= 0) {
            throw new RuntimeException("请输入正整数的台阶数");
        }
        int[] result = new int[target];
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            result[0] = 1;
            result[1] = 2;
            for (int i = 2; i < target; i++) {
                result[i] = result[i - 1] + result[i - 2];
            }
            return result[target - 1];
        }
    }
        public static void main(String[] args) {
            System.out.println(JumpFloor(29));
        }
}
