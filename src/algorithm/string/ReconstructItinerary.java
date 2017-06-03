package algorithm.string;

import java.util.*;

/**
 * Created by qun.chen on 13/5/17.
 */
public class ReconstructItinerary {

    public static void main(String[] argv){
        String[][] tickets ={{"JFK","KUL"},{"NRL","ABC"},{"KUL","NRL"}};
        List<String> result=findItinerary(tickets);
        System.out.print(result);
    }

    /**
     * 1. crate a map from departure to a queue of arrival
     * 2. populate it with tickets
     * O(nlogn)
     * @param tickets
     * @return
     */
    public static List<String> findItinerary(String[][] tickets) {
        Map<String,PriorityQueue<String>> maps=new HashMap<>();
        for(String[] strings:tickets){
            maps.computeIfAbsent(strings[0],k ->
            new PriorityQueue<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            })).add(strings[1]);
        }


        List<String> route=new LinkedList<>();

        visit("JFK",maps,route);

        return route;
    }

    /**
     * recursively built a route
     * when the destination could be found in another departure and its own destination is not empty
     * use the destination as next departure
     * when no more route, add destination to top from recursion call stack
     * O(n)
     * @param des
     * @param maps
     * @param route
     */
    public static void visit(String des,Map<String,PriorityQueue<String>> maps, List<String> route){
        while(maps.containsKey(des)&&!maps.get(des).isEmpty()){
            visit(maps.get(des).poll(),maps,route);
        }
            route.add(0,des);

    }

}
