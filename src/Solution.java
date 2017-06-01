import java.util.*;

/**
 * Created by qun.chen on 20/5/17.
 */
public class Solution {
    public static void main(String[] argv){
        String start="hit";
        String end="cog";
        String[] dic={"hot","dot","dog","lot","log","cog"};
        List<String> dictionary=new ArrayList<>();
        dictionary.addAll(Arrays.asList(dic));
        Solution solution=new Solution();
        System.out.println(solution.ladderLength(start,end,dictionary));
    }


    public int ladderLength(String word, String end, List<String> dictionary) {
        //check edge cases
        if(word==null||end==null||word.length()!=end.length()){
            return 0;
        }

        Queue<String> queue =new LinkedList<>();
        queue.add(word);//queue:["ABC"]
        int length=0;//length:0
        int index=0;//index:0
        while(!queue.isEmpty()){
            length++;//length:3
            String current=queue.poll();//current:"BCC",queue:[]
            List<String> transformedString=transform(current,index);
            for(String s:transformedString){//return ["BCA","BCB"]
                if(s.equals(end)){  //true
                    return length+1; //4
                }
                if(dictionary.contains(s)){ //true
                    queue.add(s); //queue:["BCC"]
                }
            }
            index++;//index:2
        }

        return 0;
    }

    private List<String> transform(String word,int index){
        List<String> transformedStrings=new ArrayList<>(2);
        for(char c='a';c<='z';c++){
            char[] chars=word.toCharArray();
            if(chars[index]!=c){
                chars[index]=c;
                transformedStrings.add(String.valueOf(chars));
            }
        }
        return transformedStrings;
    }

}
