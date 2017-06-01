package algorithm;

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

    public static void visit(String des,Map<String,PriorityQueue<String>> maps, List<String> route){
        while(maps.containsKey(des)&&!maps.get(des).isEmpty()){
            visit(maps.get(des).poll(),maps,route);
        }
            route.add(0,des);

    }

}
