package algorithm;

/**
 * Created by qun.chen on 1/6/17.
 */
public class Pow {

    public static void main(String[] argv){
        Pow pow=new Pow();
        System.out.print(pow.pow(-3,10));
    }

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
