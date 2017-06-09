package algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qun.chen on 9/6/17.
 */
public class PascalsTriangle2 {

    public static void main(String[] argv){
        PascalsTriangle2 pascalsTriangle2=new PascalsTriangle2();
        System.out.print(pascalsTriangle2.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> current=new ArrayList<>();
        List<Integer> previous=new ArrayList<>();
        previous.add(1);
        while(rowIndex>0){
            rowIndex--;
            current.clear();
            current.add(1);
            for(int i=0;i<previous.size()-1;i++){
                if(i+1==previous.size()){
                    current.add(previous.get(i));
                }else{
                    current.add(previous.get(i)+previous.get(i+1));
                }
            }
            current.add(1);
            previous=new ArrayList<>(current);
        }

        return previous;
    }
}
