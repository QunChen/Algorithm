package algorithm.string;

import java.util.*;

/**
 * Created by qun.chen on 4/6/17.
 */
public class LetterCombination {

    public static void main(String[] argv){
        LetterCombination letterCombination=new LetterCombination();
        System.out.print(letterCombination.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return new ArrayList<>();
        }

        Map<Integer,List<Character>> combination = new HashMap<>();

        initial(combination);

        List<String> result=new ArrayList<>();
        List<List<Character>> all=new ArrayList<>();

        for(int i=0;i<digits.length();i++){
            List<Character> temp=combination.get(digits.charAt(i)-'0');
            all.add(temp);
        }

        List<Character> list= all.get(0);
        for(Character c:list){
            result.add(String.valueOf(c));
        }

        for(int i=1;i<all.size();i++){
            List<String> temp= new ArrayList<>(result);
            result.clear();
            for(Character c:all.get(i)){
                for(String s:temp){
                    result.add(s+c);
                }
            }
        }

        return result;
    }

    private void initial(Map<Integer,List<Character>> combination){
        List<Character> two= new ArrayList<>(Arrays.asList(new Character[]{'a','b','c'}));
        List<Character> three= new ArrayList<>(Arrays.asList(new Character[]{'d','e','f'}));
        List<Character> four= new ArrayList<>(Arrays.asList(new Character[]{'g','h','i'}));
        List<Character> five= new ArrayList<>(Arrays.asList(new Character[]{'j','k','l'}));
        List<Character> six= new ArrayList<>(Arrays.asList(new Character[]{'m','n','o'}));
        List<Character> seven= new ArrayList<>(Arrays.asList(new Character[]{'p','q','r','s'}));
        List<Character> eight= new ArrayList<>(Arrays.asList(new Character[]{'t','u','v'}));
        List<Character> nine= new ArrayList<>(Arrays.asList(new Character[]{'w','x','y','z'}));

        combination.put(2,two);
        combination.put(3,three);
        combination.put(4,four);
        combination.put(5,five);
        combination.put(6,six);
        combination.put(7,seven);
        combination.put(8,eight);
        combination.put(9,nine);
    }
}
