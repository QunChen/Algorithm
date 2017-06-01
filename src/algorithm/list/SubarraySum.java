package algorithm.list;

/**
 * Created by qun.chen on 13/5/17.
 */
public class SubarraySum {

    public static void main(String[] args)
    {
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int sum = 23;
        int[] result=findSubarray(arr, sum);
        System.out.print(result);
    }

    public static int[] findSubarray(int[] a,int sum){
        int current=0;
        int start=0;
        int end=0;
        int[] result=new int[2];
        for(int i=0;i<a.length;i++){
            if(current==sum){
                result[0]=start;
                result[1]=end-1;
            } else if(current<sum){
                current+=a[i];
                end++;
            }else{
                i--;
                current-=a[start];
                start++;
            }
        }

        return result;
    }
}
