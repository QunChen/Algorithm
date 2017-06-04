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

    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++){
            result.add(i ^ i>>1);
        }
        return result;

    }
}
