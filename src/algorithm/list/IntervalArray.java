package algorithm.list;

/**
 * Created by qun.chen on 13/5/17.
 */
public class IntervalArray {

    public static void main(String[] argv){
        int[] a= {1,-1,-1,1,1,-1,1,-1};
        //sort(a);
        wiggleSort(a);
        System.out.print(a);
    }

    public static void wiggleSort(int[] a){
        for(int i=1;i<a.length;i++){
            if(i%2==0){
                if(a[i-1]<a[i]){
                    swap(a,i-1,i);
                }
            }else{
                if(a[i-1]>a[i]){
                    swap(a,i-1,i);
                }
            }
        }
    }


    public static void sort(int[] a){
        int i=0;
        int j=a.length-1;
        while(i<j){
            while((i%2==0&&a[i]<0)||(i%2==1&&a[i]>0)){
                i++;
            }
            while((j%2==0&&a[j]<0)||(j%2==1&&a[j]>0)){
                j--;
            }
            swap(a,i,j);
            i++;
            j--;
        }
    }

    public static void swap(int[]a, int i, int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
