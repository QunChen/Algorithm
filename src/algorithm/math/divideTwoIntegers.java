package algorithm.math;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by qun.chen on 21/5/17.
 */
public class divideTwoIntegers {

    /**
     * 1. considering the sign of 2 numbers
     * 2. get abosulte value of two opedends
     * 3. handle over bound issue
     * 4. return the value with right sign
     * @param dividend
     * @param divisor
     * @return
     */
        public int divide(int dividend, int divisor) {

            if(divisor==0){
                return Integer.MAX_VALUE;
            }

            if(dividend==0){
                return 0;
            }
            boolean isDividendPositive = dividend >0;
            boolean isDivisorPositive = divisor >0;

            dividend=Math.abs(dividend);
            divisor=Math.abs(divisor);

            Map<Integer,Integer> memory=new TreeMap<>(Collections.reverseOrder());//dividend->current,result
            long result=getResult(dividend,divisor,memory);

            if(result>Integer.MAX_VALUE){
                if(isDividendPositive!=isDivisorPositive){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }

            if(isDividendPositive!=isDivisorPositive){
                return -(int)result;
            }else{
                return (int)result;
            }

        }

    /**
     * 1. if dividend is smaller than divisor, return 0
     * 2. if equal, return 1
     * 3. then look for some solution in memory and update dividend and result
     * 4. then add current to itself, then it will increase at exponentially,
     * 5. when it over dividend, revoke last operation by half
     * 6. recursively call itself with remaining dividend, and sum it with result in step 3 and 4
     * Recursion function: current result+func(remaining dividend,memory)
     * O(logn)
     * @param dividend
     * @param divisor
     * @param memory
     * @return
     */
        private long getResult(int dividend,int divisor,Map<Integer,Integer> memory){

            long current=divisor;


            if(dividend<divisor){
                return 0;
            }

            if(dividend==divisor){
                return 1;
            }

            long result=1;
            int initialResult=0;

            for(Integer key:memory.keySet()){
                if(key<dividend){
                    initialResult=memory.get(key);
                    dividend-=key;
                }
                break;
            }

            while(true){
                current+=current;
                if(current<dividend){
                    result+=result;
                    memory.put((int)current,(int)result);
                }else{
                    current/=2;
                    break;
                }

            }

            return initialResult+result+getResult(dividend-(int)current,divisor,memory);
        }
}
