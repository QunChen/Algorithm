package algorithm.list;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by qun.chen on 13/5/17.
 */
public class SubarraySum {

    public static void main(String[] args)
    {
        int arr[] = {16, 2, 4, 7, 9, 5, 10, 23};
        int sum = 24;
        int[] result=findSubarray(arr, sum);
        int[] result2=findSubarray2(arr, sum);
        System.out.print(Arrays.toString(result));
        System.out.print(Arrays.toString(result2));
    }

    /**
     * use a start and end, if sum is larger than target, remove the first one
     * and then start++, if not move end, add the next
     * when equal the target, return start and end
     * or when loop to the end and not found
     * O(n)
     *
     */

    public static int[] findSubarray(int[] a,int sum){
        int current=0;
        int start=0;
        int end=0;
        int[] result=new int[2];
        for(int i=0;i<a.length;i++){
            if(current+a[i]==sum){
                result[0]=start;
                result[1]=end;
                break;
            } else if(current+a[i]<sum){
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

    /**
     * use a deque to store the subarray, offerLast to add to last, pollFirst to poll
     * the first, and peekFirst and peekLast to get the start and end index
     * O(n)
     * @param a
     * @param sum
     * @return
     */
    public static int[] findSubarray2(int[] a,int sum){
        Deque<Integer> deque=new ArrayDeque<>();

        int current=0;
        int[] result=new int[2];
        for(int i=0;i<a.length;i++){
            if(current+a[i]==sum){
                deque.offerLast(i);
                result[0]=deque.peekFirst();
                result[1]=deque.peekLast();
                break;
            }if(current+a[i]<sum){
                current+=a[i];
                deque.offerLast(i);
            }else{
                i--;
                current-=a[deque.pollFirst()];
            }
        }

        return  result;
    }
}
