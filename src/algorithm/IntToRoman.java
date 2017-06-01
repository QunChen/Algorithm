package algorithm;

/**
 * Created by qun.chen on 27/5/17.
 */
public class IntToRoman {
    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        int i=0;
        int x=0;
        int c=0;
        int m=0;

        i=num%10;
        num/=10;
        if(num>0){
            x=num%10;
            num/=10;
            if(num>0){
                c = num%10;
                num/=10;
                if(num>0){
                    m=num%10;
                }
            }
        }
        return M[m]+C[c]+X[x]+I[i];
    }
}
