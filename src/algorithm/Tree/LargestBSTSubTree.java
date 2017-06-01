//package algorithm;
//
///**
// * Created by qun.chen on 14/5/17.
// */
//public class LargestBSTSubTree {
//    String result;
//    public String getDistanceString(int n)
//    {
//        int[] visited = new int[n+1];
//        dfs(n, visited, 0, "");
//        return result;
//    }
//
//    public void dfs(int n, int[] visited, int count, String curr)
//    {
//        if(count==2*n)
//        {
//            result=curr;
//            return;
//        }
//return
//        for(int i=1;i<=n;i++)
//        {
//            if(visited[i]==0)
//            {
//                visited[i]++;
//                dfs(n, visited, count+1, curr+i);
//                visited[i]--;
//            }
//            else if(visited[i]==1)
//            {
//                if(curr.length()-i>=0&&curr.charAt(curr.length()-i)=='0'+i)
//                {
//                    visited[i]=2;
//                    dfs(n, visited, count+1, curr+i);
//                    visited[i]--;
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args)
//    {
//        LargestBSTSubTree l = new LargestBSTSubTree();
//        System.out.println(l.getDistanceString(5));
//    }
//}
