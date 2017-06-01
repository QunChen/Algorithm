package algorithm;

import java.util.*;

/**
 * Created by qun.chen on 28/5/17.
 */
public class TopKNearestPoints {

    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] argv){
        Point point1=new Point(1,1);
        Point point2=new Point(2,2);
        Point point3=new Point(3,3);
        Point point4=new Point(4,4);
        Point point5=new Point(5,5);
        List<Point> points = new ArrayList<>();
        points.add(point5);
        points.add(point4);
        points.add(point3);
        points.add(point2);
        points.add(point1);
        System.out.println(findNeariest(point3,points,3));
        System.out.println(findNeariest2(point3,points,3));
    }

    public static List<Point> findNeariest2(Point target,List<Point> points, int k){
        Collections.sort(points,(p1,p2)->(p1.x-target.x)*(p1.x-target.x)
                +(p1.y-target.y)*(p1.y-target.y)-
                (p2.x-target.x)*(p2.x-target.x)
                -(p2.y-target.y)*(p2.y-target.y));

        List<Point> results=new ArrayList<>();
        for(int i=0;i<k;i++){
            results.add(points.get(i));
        }
        return results;
    }

    public static List<Point> findNeariest(Point target,List<Point> points, int k){
        PriorityQueue<Point> queue=new PriorityQueue<>((p1,p2)->
                (p2.x-target.x)*(p2.x-target.x)
                +(p2.y-target.y)*(p2.y-target.y)-
                (p1.x-target.x)*(p1.x-target.x)
                -(p1.y-target.y)*(p1.y-target.y));

        for(Point p:points){
            queue.add(p);
            if(queue.size()>k){
                queue.poll();
            }
        }

        List<Point> results=new ArrayList<>();

        while(k>0){
            k--;
            results.add(queue.poll());
        }

        return results;

    }
}
