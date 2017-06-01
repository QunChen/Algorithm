package dataStructures;

import java.util.*;

public class ArraysLeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];

        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int result[]=new int[n];

        for(int a_i=0; a_i < n; a_i++){
            int newIndex=resolveIndex(a_i,n,k);
            result[newIndex]=a[a_i];
        }

        for(int a_i=0; a_i < n; a_i++){
            System.out.print(result[a_i]+" ");
        }
    }

    public static int resolveIndex(int oldIndex,int length,int left){
        int newIndex=oldIndex-left;
        if(newIndex<0){
            newIndex+=length;
        }
        return newIndex;
    }
}
