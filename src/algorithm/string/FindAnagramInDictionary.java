package algorithm.string;

import java.util.*;

/**
 * Created by qun.chen on 16/5/17.
 */
public class FindAnagramInDictionary {

    private Map<String,List<String>> map;

    public FindAnagramInDictionary(){
        map=new HashMap<>();
    }

    public static void main(String[] argv){
        String[] dic={"abc","cba","abd","cbd"};
        Set<String> dictionary=new HashSet<>();
        dictionary.addAll(Arrays.asList(dic));

        FindAnagramInDictionary findAnagramInDictionary=new FindAnagramInDictionary();
        findAnagramInDictionary.loopDictionary(dictionary);
        System.out.print(findAnagramInDictionary.isAnagram("abf"));


    }

    /**
     * 1. convert to alphabet occurrence info
     * 2. check whether it is an anagram in dictionary
     * O(1)
     * @param word
     * @return
     */
    public boolean isAnagram(String word){
        String key=toKeyString(word);
        if(map.containsKey(key)){
            return true;
        }
        return false;
    }

    /**
     * loop dictionary
     * use a map from transformed string to actual string
     * o(n)
     * @param dictionary
     */
    public void loopDictionary(Set<String> dictionary){
        for(String s:dictionary){
            String key=toKeyString(s);
            map.computeIfAbsent(key,k->new ArrayList<>());
            map.get(key).add(s);
        }
    }

    /**
     * 1. create an array to store all letters int[26]
     * 2. count occurrences of each alphabet
     * 3. reconstruct to number of element occurrences value.
     * O(1)
     * @param word
     * @return
     */
    public String toKeyString(String word){
        int[] charKey=new int[26];

        char[] chars=word.toCharArray();
        for(char c:chars){
            charKey[c-'a']++;
        }

        StringBuffer stringBuffer=new StringBuffer("");
        for(int i:charKey){
            stringBuffer.append(i);
            stringBuffer.append(",");
        }

        return stringBuffer.toString();
    }
}
