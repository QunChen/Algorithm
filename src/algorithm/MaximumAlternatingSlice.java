package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qun.chen on 24/5/17.
 */
public class MaximumAlternatingSlice {

    public static void main(String[] argv){
        int[] origin= {1, -5, 23, 0, 1, 1, 0, 2, -5, 3, -1, 1, 2, 3};
        System.out.print(find(origin));
    }

    public static List<Integer> find(int[] origin){
        if(origin==null){
            return null;
        }

        List<Integer> longest=new ArrayList<>();
        List<Integer> current=new ArrayList<>();

        boolean isPositive=origin[0]>0;

        for(int i=0;i<origin.length;i++){
            if(origin[i]>0&&isPositive){
                current.add(origin[i]);
                isPositive=!isPositive;
            }
            else if(origin[i]<0&&!isPositive){
                current.add(origin[i]);
                isPositive=!isPositive;
            }
            else if(origin[i]==0){
                current.add(origin[i]);
                isPositive=!isPositive;
            }else{
                isPositive=origin[i]<0;
                if(current.size()>longest.size()){
                    longest=new ArrayList<>(current);
                }
                current.clear();
                current.add(origin[i]);
            }
        }
        return longest;
    }
}
