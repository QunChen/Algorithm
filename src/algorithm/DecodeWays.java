package algorithm;

/**
 * Created by qun.chen on 31/5/17.
 */
public class DecodeWays {

    public  static void main(String[] argv){
        DecodeWays decodeWays=new DecodeWays();
        System.out.print(decodeWays.numDecodings("25"));
    }

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
