package algorithm;

import java.util.*;

/**
 * Created by qun.chen on 17/5/17.
 */
public class TaskThreadCount {

    public static void main(String[] argv){
        List<Task> tasks=new ArrayList<>();
        tasks.add(new Task(4,6));
        tasks.add(new Task(2,5));
        tasks.add(new Task(3,5));
        tasks.add(new Task(1,5));

        TaskThreadCount taskThreadCount=new TaskThreadCount();
        System.out.print(taskThreadCount.getMaxThread(tasks));

    }

    private static class Task implements Comparable<Task>{
        public int start;
        public int end;

        public Task(int start,int end){
            this.start=start;
            this.end=end;
        }

        @Override
        public int compareTo(Task other){
            return this.start-other.start;
        }
    }

    public int getMaxThread(List<Task> tasks){
         Collections.sort(tasks);
         int processed=0;
         int timeline=0;
         int max=0;
         List<Task> inProgress=new LinkedList<>();
         while(processed<tasks.size()){
             timeline++;
             while(processed<tasks.size()&&timeline==tasks.get(processed).start){
                 inProgress.add(tasks.get(processed));
                 processed++;
             }
             Iterator<Task> taskIterator=inProgress.iterator();
             while(taskIterator.hasNext()){
                 Task task=taskIterator.next();
                 if(task.end==timeline){
                     taskIterator.remove();
                 }
             }
             if(inProgress.size()>max){
                 max=inProgress.size();
             }
         }

         return max;
    }
}
