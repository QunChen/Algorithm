package algorithm.graph;

import java.util.*;

/**
 * Created by qun.chen on 20/5/17.
 */
public class GateAndWater {

    public static void main(String[] argv){
        String[][] grid={{"","","","",""}
        ,{"","W","B","J",""}
        ,{"","","B","W",""}
        ,{"","G","","B",""}
        ,{"","","","",""}};

        GateAndWater gateAndWater =new GateAndWater();
        System.out.print(gateAndWater.findMinPath(grid,1,3));
    }

    /**
     * BFS
     * 1. use null as level indicator
     * 2. use a set as visited
     * 3. increase level when reaching null indicator
     * 4. use a map from level to neighbour nodes for water cell
     * 5. add block and not visited neighbour and water ones at the same level
     * 6. when reaching target return levels
     * @param grid
     * @param startRow
     * @param startCol
     * @return
     */
    public int findMinPath(String[][] grid, int startRow,int startCol){
        Queue<List<Integer>> queue =new LinkedList<>();
        Integer[] point={startRow,startCol};
        queue.add(Arrays.asList(point));
        queue.add(null);

        Set<List<Integer>> visited=new HashSet<>();
        visited.add(Arrays.asList(point));

        Map<Integer,List<List<Integer>>> water=new HashMap<>();///key :length -> value -> point;

        int length=1;

        while(!queue.isEmpty()){
            List<Integer> cur=queue.poll();

            if(cur==null){

                if(!queue.isEmpty()){

                    length++;
                    if(water.containsKey(length)){
                        queue.addAll(water.get(length));
                    }
                    queue.add(null);
                }
            }else{

                List<List<Integer>> neighbours= getNeighbour(cur,grid.length,grid[0].length);
                for(List<Integer> neighbour:neighbours){
                    int row=neighbour.get(0);
                    int col=neighbour.get(1);
                    if(grid[row][col].equals("G")){
                        return length+1;
                    }else if(grid[row][col].equals("W")&&!visited.contains(neighbour)){
                        if(water.containsKey(length+3)){
                            water.get(length+3).add(neighbour);
                        }else{
                            List<List<Integer>> newList=new ArrayList<>();
                            newList.add(neighbour);
                            water.put(length+3,newList);
                        }

                    }else if(!grid[row][col].equals("B")&&!visited.contains(neighbour)) {
                        queue.add(neighbour);

                    }
                    visited.add(neighbour);
                }

            }
        }
        return 0;
    }

    /**
     * find 8 neighbours in different directions
     * @param cur
     * @param rowSize
     * @param colSize
     * @return
     */
    private List<List<Integer>> getNeighbour(List<Integer> cur,int rowSize,int colSize){
        List<List<Integer>> neighbours=new ArrayList<>();
        int row=cur.get(0);
        int col=cur.get(1);

        if(row-1>=0&&col-1>=0){neighbours.add(Arrays.asList(new Integer[]{row-1,col-1}));}
        if(row-1>=0){neighbours.add(Arrays.asList(new Integer[]{row-1,col}));}
        if(row-1>=0&&col+1<colSize){neighbours.add(Arrays.asList(new Integer[]{row-1,col+1}));}
        if(col-1>=0){neighbours.add(Arrays.asList(new Integer[]{row,col-1}));}
        if(col+1<colSize){neighbours.add(Arrays.asList(new Integer[]{row,col+1}));}
        if(row+1<rowSize&&col-1>=0){neighbours.add(Arrays.asList(new Integer[]{row+1,col-1}));}
        if(row+1<rowSize){neighbours.add(Arrays.asList(new Integer[]{row+1,col}));}
        if(row+1<rowSize&&col+1<colSize){neighbours.add(Arrays.asList(new Integer[]{row+1,col+1}));}

        return neighbours;

    }
}
