package algorithm;

import java.util.*;

/**
 * Created by qun.chen on 18/5/17.
 */
public class MeetingRoom {

    public static void main(String[] argv){
        Integer[][] ints={{0,30},{5,10},{15,20}};
        List<Integer[]> times= new ArrayList<>();
        for(Integer[] i:ints){
            times.add(i);
        }
        MeetingRoom meetingRoom=new MeetingRoom();
        System.out.print(meetingRoom.isOk(times));


        Integer[][] ints2={{75,90},{55,70},{0,30},{35,50}};
        List<Integer[]> times2= new ArrayList<>();
        for(Integer[] i:ints2){
            times2.add(i);
        }

        System.out.print(meetingRoom.isOk(times2));
    }


    public boolean isOk(List<Integer[]> times) {
        Collections.sort(times, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < times.size() - 2; i++) {
            int end = times.get(i)[1];
            if (times.get(i + 1)[0] < end) {
                return false;
            } else {
                end = Math.max(end, times.get(i + 1)[1]);
            }

        }
        return true;
    }
}
