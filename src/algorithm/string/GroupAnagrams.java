package algorithm.string;

import java.util.*;

/**
 * Created by qun.chen on 13/5/17.
 */
public class GroupAnagrams {

    public static void main(String[] argv){
        String[] strings={"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result=findGroupAnagrams(Arrays.asList(strings));
        System.out.print(result);
    }

    /**
     * use a map from alphabet sorted string to a list of actual string
     * print all lists
     * O(n*length)
     * @param lists
     * @return
     */
    public static List<List<String>> findGroupAnagrams(List<String> lists){
        Map<String,List<String>> maps=new HashMap<>();
        for(String s:lists){
            String sorted=sort(s);
            if(!maps.containsKey(sorted)){
                List<String> strings=new ArrayList<>();
                maps.put(sorted,strings);
            }
            maps.get(sorted).add(s);
        }
        List<List<String>> result=new ArrayList<>();
        for(List<String> strings:maps.values()){
            result.add(strings);
        }

        return result;
    }

    /**
     * sort all characters in a string
     * O(length)
     * @param s
     * @return
     */
    public static String sort(String s){
        char[] chars=s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
