package algorithm;

/**
 * Created by qun.chen on 27/5/17.
 */
public class FindHeavierBall {

    public static void main(String[] argv) {
        int[] nums={1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1};
        System.out.print(findHeavier(nums,0,nums.length-1));
    }

    public static int findHeavier(int[] nums, int start, int end) {
        int size = (end - start + 1) / 3;
        int sum1 = getSum(nums, 0, size - 1);
        int sum2 = getSum(nums, size, 2 * size - 1);
        int sum3 = getSum(nums, 2 * size, 3 * size - 1);


        if (sum1 > sum2 || sum1 > sum3) {
            if (size == 1) {
                return start;
            }
            return findHeavier(nums, 0, size - 1);
        }
        if (sum2 > sum1 || sum2 > sum3) {
            if (size == 1) {
                return size+start;
            }
            return findHeavier(nums, size, 2 * size - 1);
        }
        if (sum3 > sum1 || sum3 > sum2) {
            if (size == 1) {
                return 2 * size+start;
            }
            return findHeavier(nums, 2 * size, 3 * size - 1);
        }

        if (end - start - (3 * size - 1) == 1) {
            return 3 * size;
        } else {
            if (nums[3 * size] > nums[3 * size + 1]) {
                return 3 * size+start;
            } else {
                return 3 * size + 1+start;
            }
        }
    }

    private static int getSum(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
