package algorithm;

/**
 * Created by qun.chen on 27/5/17.
 */
public class StringToInteger {
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

            if(Integer.MAX_VALUE/10<total||Integer.MAX_VALUE/10==total&&Integer.MAX_VALUE%10<digit){
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
