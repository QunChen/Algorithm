package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by qun.chen on 13/5/17.
 */
public class FindOddOccurance {

    public static void main(String[] argv){
        int[] ints={1, 2, 3, 2, 3, 1, 3};
        System.out.print(find(ints));
    }

    public static int find(int[] a){
        Map<Integer,Boolean> occurance=new HashMap<>();

        for(int i=0;i<a.length;i++){
            if(occurance.containsKey(a[i])){
                occurance.put(a[i],!occurance.get(a[i]));
            }else{
                occurance.put(a[i],true);
            }
        }

        for(Entry<Integer,Boolean> e:occurance.entrySet()){
            if(e.getValue()){
                return e.getKey();
            }
        }

        return  -1;
    }
}
