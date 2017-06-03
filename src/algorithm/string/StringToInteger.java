package algorithm.string;

/**
 * Created by qun.chen on 27/5/17.
 */
public class StringToInteger {
    /**
     * 1. trim the leading empty
     * 2. set the sign
     * 3. read the remaining,
     * a. if found not digit break;
     * 4. get the digit
     * 5. check boundary of integer, if times 10 will over max value, return max value for positive and min value for negative
     * 6. current total times 10 plus current digit
     * 7. set the sign
     * O(str length)
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if(str==null||str.equals("")){
            return 0;
        }

        int index=0;
        boolean isPositive=true;
        int total=0;

        while(index<str.length()&&str.charAt(index)==' '){
            index++;
        }

        if(str.charAt(index)=='-'||str.charAt(index)=='+'){
            if(str.charAt(index)=='+'){
                isPositive=true;

            }
            if(str.charAt(index)=='-'){
                isPositive=false;

            }
            index++;
        }


        while(index<str.length()){
            if(!Character.isDigit(str.charAt(index))){
                break;
            }

            int digit=str.charAt(index)-'0';

            if(Integer.MAX_VALUE/10<total||(Integer.MAX_VALUE/10==total&&Integer.MAX_VALUE%10<digit)){
                if(!isPositive){
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }


            total=total*10+digit;

            index++;
        }

        if(!isPositive){
            return -total;
        }
        return total;
    }
}
