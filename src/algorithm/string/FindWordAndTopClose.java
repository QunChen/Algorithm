package algorithm.string;

import java.util.*;

/**
 * Created by qun.chen on 14/5/17.
 */
public class FindWordAndTopClose {

    public static void main(String[] argv){
        String[] strings={"abc","abd","abe","abf","abg"};

        Set<String> dic=new HashSet<>();
        dic.addAll(Arrays.asList(strings));

        String[] result=findWord(dic,"abz");
        System.out.print(result);
    }

    public static String[] findWord(Set<String> dic, String word){
        String[] result=new String[5];
        if(dic.contains(word)){
            result[0]=word;
        }else{
            result=findSimilar(dic,word);
        }

        return result;
    }

    /**
     * find top 5 most similar word
     * O(n)
     * @param dic
     * @param word
     * @return
     */
    public static String[] findSimilar(Set<String> dic, String word){
        String[] result=new String[5];
        int count=0;
        List<String> similar=getSimilar(word);
        while(count<5){
            for(String s:similar){
                if(dic.contains(s)){
                    result[count]=s;
                    count++;
                }
            }
        }
        return  result;
    }

    /**
     * a easy function that change 1 character of original word
     * @param word
     * @return
     */
    public static List<String> getSimilar(String word){

        List<String> similar=new ArrayList<>();

        for(char a='a';a<'z';a++){
            for(int i=0;i<word.length();i++){
                char[] chars=word.toCharArray();
                chars[i]=a;
                similar.add(String.valueOf(chars));
            }
        }

        return similar;
    }
}
