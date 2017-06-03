package algorithm.dp;

/**
 * Created by qun.chen on 31/5/17.
 */
public class DecodeWays {

    public  static void main(String[] argv){
        DecodeWays decodeWays=new DecodeWays();
        System.out.print(decodeWays.numDecodings("25"));
    }

    /**
     * DP
     * 1. create an array for remembering current solutions, length is size+1
     * 2. make the last element in memory 1, not the actual element, just for calculating later.
     * 3. if the last character is not 0, make the second last element in memory 1, there should be at least 1 way
     * 4. the loop starts from second last element and
     * a. 0, than can not parse, move forward
     * b. if it and next combined less than 26, that means current one can be constructed from previous one
     * and previous next one.
     * c. if larger than 26, only from previous one
     * 5. when reaching the start of the string, return the first value in the array memory.
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if(s==null||s.length()==0){
            return 0;
        }

        int n=s.length();
        int[] mem=new int[n+1];

        mem[n]=1;
        if(Integer.parseInt(s.substring(n-1))!=0){
            mem[n-1]=1;
        }

        for(int i=n-2;i>=0;i--){
            if(Integer.parseInt(s.substring(i,i+1))==0){
                continue;
            }
            if(Integer.parseInt(s.substring(i,i+2))<26){
                mem[i]=mem[i+1]+mem[i+2];
            }else{
                mem[i]=mem[i+1];
            }
        }

        return mem[0];
    }
}
