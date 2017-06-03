package algorithm.list;

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

    /**
     * compare by start time
     */
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

    /**
     * 1. sort by start time
     * 2. set value for max, processed,timeline and a list for in progress taskss
     * 3. when not all are processed, increase timeline, if reaching a start, add it into in progress list
     * 4. in each timeline, loop all in progress task, if reaches its end time, remove it from in progress list
     * 5. update the max with the size of in progres  list
     * O(tn)
     * @param tasks
     * @return
     */
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
