package algorithm.list;

/**
 * Created by qun.chen on 9/6/17.
 */
public class RotateFunction {

    public static void main(String[] argv){
        int[] A={4, 3, 2, 6};
        RotateFunction rotateFunction=new RotateFunction();
        System.out.println(rotateFunction.maxRotateFunction(A));
    }

    public int maxRotateFunction(int[] A) {
        if(A==null||A.length==0){
            return 0;
        }
        int base=sum(A);
        int total=total(A);
        int max=base;
        int sum=base;
        int n= A.length;

        for(int i=n-1;i>0;i--){
            sum+=total-n*A[i];
            max=Math.max(sum,max);
        }
        return max;

    }

    private int total(int[] A){
        int sum=0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
        }
        return sum;
    }

    private int sum(int[] A){
        int sum=0;
        for(int i=0;i<A.length;i++){
            sum+=i*A[i];
        }
        return sum;
    }
}
