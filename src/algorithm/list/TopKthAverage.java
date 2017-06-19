package algorithm.list;

import java.util.*;

/**
 * Created by qun.chen on 24/5/17.
 */
public class TopKthAverage {

    public static void main(String[] argv){
        List<Result> data=new ArrayList<>();
        data.add(new Result(1,1));
        data.add(new Result(2,2));
        data.add(new Result(3,3));
        data.add(new Result(3,4));
        data.add(new Result(2,5));
        data.add(new Result(1,6));
        data.add(new Result(1,7));
        data.add(new Result(2,8));
        data.add(new Result(1,9));

        System.out.print(getTopKthAverage(data,3));

    }

    public static class Result {
        public int id;
        public int score;
        public Result(int id,int score){
            this.id=id;
            this.score=score;
        }
    }

    /**
     * 1. create one map from id to a max heap of scores
     * 2. create a map from id to average
     * 3. add all to map in step 1
     * 4. add result to map in step 2
     * O(nlogn)
     * @param data
     * @param k
     * @return
     */
    public static Map<Integer,Double> getTopKthAverage(List<Result> data,int k){
        if(data==null||data.isEmpty()){
            return null;
        }
        Map<Integer,PriorityQueue<Integer>> scoreMap = new HashMap<>();
        Map<Integer,Double> results = new HashMap<>();

        for(Result result: data){
            scoreMap.computeIfAbsent(result.id, val -> new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            }));

            scoreMap.get(result.id).add(result.score);
        }

        for(Integer id : scoreMap.keySet()){
            results.put(id,getAverage(scoreMap.get(id),k));
        }

        return results;
    }

    /**
     * get average of first k element in a min heap
     * O(min(n,k))
     * @param queue
     * @param k
     * @return
     */
    private static double getAverage(PriorityQueue<Integer> queue,int k){
        double result=0;
        int total=0;
        while(!queue.isEmpty()&&k>0){
            result+=queue.poll();
            k--;
            total++;
        }
        return result/total;
    }
}
