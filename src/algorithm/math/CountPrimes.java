package algorithm.math;

/**
 * Created by qun.chen on 6/6/17.
 */
public class CountPrimes {

    public static void main(String[] argv){
        CountPrimes countPrimes=new CountPrimes();
        System.out.print(countPrimes.countPrimes(10));
    }

    /**
     * create a boolean array
     * start from 2, make all element times 2 true, which means is not prime
     * start from next not prime number and count
     * O(n)
     * @param n
     * @return
     */
    public int countPrimes(int n) {

        if(n<=2){
            return 0;
        }

        boolean[] isNotPrime = new boolean[n];

        int count=0;

        for(int i=2;i<n;i++){
            if(!isNotPrime[i]){
                count++;
                for(int j=i;j<n;j+=i){
                    isNotPrime[j]=true;
                }
            }
        }

        return count;
    }
}
