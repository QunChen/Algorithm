package algorithm.math;

/**
 * Created by qun.chen on 1/6/17.
 */
public class Pow {

    public static void main(String[] argv){
        Pow pow=new Pow();
        System.out.print(pow.pow(-3,10));
    }

    /**
     * if factor is negative, return 1/powRec()
     *
     * @param base
     * @param factor
     * @return
     */
    public double pow(int base,int factor){
        if(base==0) {
            return 0;
        }

        if(factor<0){
            return (double)1/powRec(base,-factor);
        }else if(factor>0){
            return powRec(base,factor);
        }else {
            return 1;
        }
    }

    /**
     * base case:
     * factor is 0, any number power 0 is 1
     * factor is 1, any number power 1 is itself
     * 1. cal calculate the pow using half factor
     * a. factor is odd, then use step 1 result times step 1 result and base
     * b. factor is even, then use step 1 result times step 1 result
     * Recursion function: func(factor/2)*func(factor/2) OR func(factor/2)*func(factor/2)*base
     * O(logn)
     * @param base
     * @param factor
     * @return
     */
    private long powRec(int base,int factor){
        if(factor==0){
            return 1;
        }
        if(factor==1){
            return base;
        }
            long sub=powRec(base,factor/2);
            if(factor%2==1){

                return base*sub*sub;
            }else{
                return sub*sub;
            }
    }
}
