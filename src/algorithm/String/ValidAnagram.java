package algorithm.String;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qun.chen on 30/5/17.
 */
public class ValidAnagram {

    public static void main(String[] argv){
        ValidAnagram validAnagram=new ValidAnagram();
        System.out.print(validAnagram.isAnagram("",""));
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] sChars = s.toCharArray();
        for (char c : sChars) {
            map.computeIfAbsent(c, k -> new Integer(0));
            int cur = map.get(c).intValue();
            map.put(c, cur + 1);
        }

        char[] tChars = t.toCharArray();
        {
            for (char c : tChars) {
                if (map.containsKey(c)) {
                    int cur = map.get(c).intValue();
                    if (cur - 1 == 0) {
                        map.remove(c);
                    } else {
                        map.put(c, cur - 1);
                    }
                } else {
                    return false;
                }
            }

            if (!map.isEmpty()) {
                return false;
            }

            return true;
        }
    }
}
