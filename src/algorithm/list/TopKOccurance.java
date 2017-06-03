package algorithm.list;

import java.util.*;

/**
 * Created by qun.chen on 24/5/17.
 */
public class TopKOccurance {

    public static void main(String[] argv){
        String[] words={"a","b","c","a","c","e","d","r","t","p","j"};
        List<String> book = new ArrayList<>(Arrays.asList(words));

        System.out.print(findTopKOccurance(book,2));
    }

    /**
     * 1. create a map from string to number of occurrence
     * 2. create a max heap by value in the map in step 1
     * 3. add all strings to map
     * 4. add all strings to heap
     * 5. poll until k
     * O(nlogn)
     * @param book
     * @param K
     * @return
     */
    public static List<String> findTopKOccurance(List<String> book, int K){

        if(K<=0||book==null||book.size()==0){
            return null;
        }

        Map<String,Integer> countMap=new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(
                (s1,s2)-> countMap.get(s2)-countMap.get(s1)
            );

        for(String s:book){
            countMap.computeIfAbsent(s,value->new Integer(0));
            int count=countMap.get(s);
            countMap.put(s,count+1);
        }

        for(String s:countMap.keySet()){
            queue.add(s);
        }
        List<String> results=new ArrayList<>();

        for(int i=0;i<K;i++){
            results.add(queue.poll());
        }

        return results;
    }
}
