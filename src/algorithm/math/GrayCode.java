package algorithm.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qun.chen on 4/6/17.
 */
public class GrayCode {

    public static void main(String[] argv){
        GrayCode grayCode=new GrayCode();
        System.out.print(grayCode.grayCode(2));
    }

    /**
     * for a number get all combination less that it bit size, like 2  less than 100 (4)
     * for each number xor with half of itself,add to result
     * O(2^n)
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++){
            result.add(i ^ i>>1);
        }
        return result;

    }
}
