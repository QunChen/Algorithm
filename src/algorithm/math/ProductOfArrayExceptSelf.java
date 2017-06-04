package algorithm.math;

import java.util.Arrays;

/**
 * Created by qun.chen on 4/6/17.
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] argv) {
        int[] nums = {0, 1};
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        System.out.print(Arrays.toString(productOfArrayExceptSelf.productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] pre = new int[nums.length + 1];
        int[] post = new int[nums.length + 1];

        pre[0] = 1;
        post[nums.length] = 1;

        for (int i = 0; i < nums.length - 1; i++) {

            pre[i + 1] = pre[i] * nums[i];

        }
        for (int i = nums.length - 1; i >= 0; i--) {
            post[i] = post[i + 1] * nums[i];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = pre[i] * post[i + 1];
        }

        return result;
    }
}
