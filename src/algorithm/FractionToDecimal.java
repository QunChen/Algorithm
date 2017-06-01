package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qun.chen on 30/5/17.
 */
public class FractionToDecimal {

    public static void main(String[] argv){
        FractionToDecimal fractionToDecimal=new FractionToDecimal();
        System.out.println(fractionToDecimal.fractionToDecimal(-1,-2147483648));
//       System.out.println(fractionToDecimal.fractionToDecimal(2,1));
//        System.out.println(fractionToDecimal.fractionToDecimal(11,6));
    }
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator==0){
            return "";
        }
        if(numerator==0){
            return "0";
        }

        String result="";

        if((numerator>0)!=(denominator>0)){
            result+="-";
        }
        long num=Math.abs((long)numerator);
        long den=Math.abs((long)denominator);

        result+=num/den;
        num%=den;

        if(num==0){
            return result;
        }

        result+=".";

        Map<Long,Integer> map=new HashMap<>();
        map.put(num,result.length());

        while(num!=0){
            num*=10;
            result+=num/den;

            num%=den;
            if(map.containsKey(num)){
                int position=map.get(num);
                String first=result.substring(0,position);
                String last=result.substring(position);
                result=first+"("+last+")";
                break;
            }else{
                map.put(num,result.length());
            }

        }

        return result;
    }
}
