package algorithm.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by qun.chen on 22/5/17.
 *
 */
public class IsomorphicStrings {

    /**
     * 1. make a set as visited, make a map from character in s to character in t
     * 2. if not contained,if already be mapped, means this new mapping is wrong, return false
     * 3. push a new mapping, add to visited
     * 4. if found, then check value with t, return false when different
     * O(n)
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map=new HashMap<>();
        Set<Character> visited=new HashSet<>();

        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }else{
                if(visited.contains(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i),t.charAt(i));
                visited.add(t.charAt(i));
            }
        }

        return true;
    }
}
