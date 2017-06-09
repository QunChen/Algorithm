package algorithm.math;

/**
 * Created by qun.chen on 6/6/17.
 */
public class CountPrimes {

    public static void main(String[] argv){
        CountPrimes countPrimes=new CountPrimes();
        System.out.print(countPrimes.countPrimes(10));
    }

    public int countPrimes(int n) {

        if(n<=2){
            return 0;
        }

        boolean[] isPrime = new boolean[n];

        int count=0;

        for(int i=2;i<n;i++){
            if(!isPrime[i]){
                count++;
                for(int j=i;j<n;j+=i){
                    isPrime[j]=true;
                }
            }
        }

        return count;
    }
}
