package algorithm.math;

import java.util.*;

/**
 * Created by qun.chen on 29/5/17.
 */
public class Skyline {

    //[[3,10,20],[3,9,19],[3,8,18],[3,7,17],[3,6,16],[3,5,15],[3,4,14]]
    public static void main(String[] argv){
        int[][] data={{0,2,3},{2,5,3}};
        Skyline skyline=new Skyline();
        List<int[]> result=skyline.getSkyline(data);
        System.out.print(result);

    }

    /**
     * 1. use a list to store height for all left top and right top corner, which are a height is enable and disable
     * the left one is minus for sorting purpose and easy to differentiate
     * 2. sort all heights first by left than right
     * 3. create a max heap for find the largest height
     * 4. loop the height, for left,
     * a. if higher than previous highest in the max heap, save it to result
     * b. otherwise, add to max heap
     * 5. for right, if disable the current highest, remove it from max heap, if it higher than next highest, save it to result
     * O(nlogn)
     * @param buildings
     * @return
     */
    public List<int[]> getSkyline(int[][] buildings) {

        List<int[]> result=new ArrayList<>();
        List<Integer[]> heights=new ArrayList<>();

        for(int[] ints:buildings){
            int left=ints[0];
            int right=ints[1];
            int height=ints[2];

            heights.add(new Integer[]{left,-height});
            heights.add(new Integer[]{right,height});
        }



        Collections.sort(heights,(h1,h2)->
        {
            if(h1[0]==h2[0]){
                return h1[1]-h2[1];
            }else{
                return h1[0]-h2[0];
            }
        });

        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
        max.add(0);

        for(Integer[] i:heights){

            if(i[1]<0){
                if(-i[1]>max.peek()){
                    result.add(new int[]{i[0],-i[1]});
                }
                max.add(-i[1]);
            }else{

                if(i[1].intValue()==max.peek().intValue()){
                    max.remove(i[1]);
                    if(i[1]>max.peek()){
                        result.add(new int[]{i[0],max.peek()});
                    }
                }else{
                    max.remove(i[1]);
                }
            }
        }
        return result;
    }
}
