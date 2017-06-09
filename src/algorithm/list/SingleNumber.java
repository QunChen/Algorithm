package algorithm.list;

/**
 * Created by qun.chen on 8/6/17.
 */
public class SingleNumber {

    public static void main(String[] argv){
        SingleNumber singleNumber=new SingleNumber();
        int[] nums={1,2,3,3,2,1,4};
        System.out.print(singleNumber.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum^=i;
        }
        return sum;
    }
}
