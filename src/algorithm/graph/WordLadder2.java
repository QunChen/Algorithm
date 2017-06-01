package algorithm.graph;

import java.util.*;

/**
 * Created by qun.chen on 26/5/17.
 */
public class WordLadder2 {

    public static void main(String[] argv){
        WordLadder2 wordLadder2=new WordLadder2();
        String beginWord = "lost";
        String endWord = "cost";
        String[] wordList = {"most","fist","lost","cost","fish"};
        System.out.print(wordLadder2.findLadders(beginWord,endWord,new ArrayList<>(Arrays.asList(wordList))));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(beginWord==null||endWord==null||beginWord.length()!=endWord.length()){
            return new ArrayList<>();
        }

        Map<String,Set<List<String>>> map = new HashMap<>();
        Set<String> wordSet= new HashSet<>();
        wordSet.addAll(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        queue.add(null);//level diff

        Set<List<String>> rootPath=new HashSet<>();
        List<String> path1=new ArrayList<>();
        path1.add(beginWord);
        rootPath.add(path1);
        map.put(beginWord,rootPath);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        Set<String> levelVisited=new HashSet<>();
        visited.add(beginWord);


        boolean isFind=false;
        while(!queue.isEmpty()){
            String current=queue.poll();

            if(current==null){
                if(isFind){
                    break;
                }
                visited.addAll(new HashSet<>(levelVisited));
                levelVisited.clear();
                if(!queue.isEmpty()){
                    queue.add(null);
                }
            }else{
                List<String> neighbours=transform(current,visited,wordSet);
                for(String s:neighbours){
                    if(s.equals(endWord)){
                        isFind=true;
                    }else{
                        queue.add(s);
                        visited.add(s);
                        levelVisited.add(s);
                    }
                    addPath(map,current,s);

                }
            }
            visited.removeAll(levelVisited);

        }

        if(map.containsKey(endWord)){

            List<List<String>> result=new ArrayList<>();
            result.addAll(map.get(endWord));
            return result;
        }else{
            return new ArrayList<>();
        }

    }

    private void addPath(Map<String,Set<List<String>>> map, String parent, String child){
        Set<List<String>> parentPath=map.get(parent);
        Set<List<String>> childPath=new HashSet<>();
        for(List<String> list:parentPath){
            List<String> newPath = new ArrayList<>();
            newPath.addAll(list);
            newPath.add(child);
            childPath.add(newPath);
        }
        if(map.containsKey(child)){
            Set<List<String>> current=map.get(child);
            for(List<String> list:childPath){
                current.add(list);
            }
            map.put(child,current);
        }else{
            map.put(child,childPath);
        }

    }

    private List<String> transform(String word,Set<String> visited,Set<String> wordSet){
        List<String> result=new ArrayList<>();
        for(int i=0;i<word.length();i++){
            char[] chars=word.toCharArray();
            for(char a='a';a<='z';a++){
                chars[i]=a;
                String newWord=new String(chars);
                if(!visited.contains(newWord)&&!word.equals(newWord)&&wordSet.contains(newWord)){
                    result.add(newWord);
                }
            }
        }
        return result;
    }
}
