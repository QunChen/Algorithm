package algorithm.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by qun.chen on 10/5/17.
 * time: O(n^2)
 * space: O(n)
 */
public class WordBreak {

    public static void main(String[] argv) {
        Set<String> dictionaries = new HashSet<>();
        dictionaries.add("ice");
        dictionaries.add("icecream");
        dictionaries.add("sam");
        dictionaries.add("samsung");

        System.out.print(isFind("icecreamsamsung", dictionaries, 0, new HashSet<>()));
        System.out.print(workBreak("samsung", dictionaries));
    }

    /**
     * first find a word, then use the remaining to find more word, remember false cases
     * recursive function word&&Func(remaining)
     * @param source
     * @param dictionaries
     * @param index
     * @param memory
     * @return
     */
    public static boolean isFind(String source, Set<String> dictionaries, int index, Set<String> memory) {
        if (index == source.length()) {
            return true;
        }

        if (memory.contains(source.substring(index))) {
            return false;
        }

        String word = "";
        for (int i = index; i < source.length(); i++) {
            word += source.charAt(i);
            if (dictionaries.contains(word)) {
                if (isFind(source, dictionaries, i + 1, memory)) {
                    return true;
                }
            }
        }

        memory.add(source.substring(index));
        return false;
    }

    /**
     * 1. create an array
     * 2. make the first true
     * 3. start from a true cell, try to make the remaining true, if any substring in the way is true, make it true
     * 4. look the next true cell and process left
     * 5. after process from all true cell as starting point, check the last element in the array
     * @param s
     * @param dictionaries
     * @return
     */
    public static boolean workBreak(String s, Set<String> dictionaries) {
        boolean[] memory = new boolean[s.length()+1];

        memory[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if (memory[i]) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String sub=s.substring(i, j);
                    if (dictionaries.contains(sub)) {
                        memory[j] = true;
                    }
                }
            }
        }
        return memory[s.length()];
    }
}
