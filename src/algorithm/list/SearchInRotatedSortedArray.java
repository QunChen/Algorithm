package algorithm.list;

/**
 * Created by qun.chen on 8/6/17.
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] argv){
        int[] nums={1,3};
        SearchInRotatedSortedArray searchInRotatedSortedArray=new SearchInRotatedSortedArray();
        System.out.print(searchInRotatedSortedArray.search(nums,2));
    }

    /**
     * 1. find the mid, if eqauls, then found
     * 2. if left is in order, if the number in the left half range, search left half, otherwise search right half
     * 3. if right is in order, if the number in the right half range, search right half, otherwise search left half
     * O(logn)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }

        if(nums.length==1){
            if(nums[0]==target){
                return 0;
            }else{
                return -1;
            }
        }

        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=(start+end)/2;  //3

            if(nums[mid]==target){
                return mid;
            }


            if(nums[start]<=nums[mid]) {
               if(target>=nums[start]&&target<=nums[mid]){
                   end=mid-1;
               }else{
                   start=mid+1;
               }
            }else if(nums[mid]<=nums[end]){
                if(target>=nums[mid]&&target<=nums[end]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}
