package ymx;

import java.util.Stack;

/**
 * Created by qun.chen on 7/5/17.
 */
public class Q1 {

    public static void main(String[] argv){
        String[] s= {"Z","X","9","+","+"};

        System.out.print(totalScore(s,5));
    }


    public static int totalScore(String[] blocks, int n)
    {
        Stack<Integer> valueStack=new Stack<>();

        for(int i=0;i<n;i++){
            String s=blocks[i];
            if(isInteger(s)){
                valueStack.push(Integer.parseInt(s));
            }else if(s.equals("Z")){
                if(!valueStack.isEmpty()){
                    valueStack.pop();
                }


            }else if(s.equals("X")){
                if(!valueStack.isEmpty()) {
                    int pop = valueStack.peek();
                    valueStack.push(pop * 2);
                }

            }else if(s.equals("+")){
                int op1,op2;
                if(!valueStack.isEmpty()){
                    op1=valueStack.pop();
                    if(!valueStack.isEmpty()){
                        op2=valueStack.pop();
                        valueStack.push(op2);
                        valueStack.push(op1);
                        valueStack.push(op1+op2);
                    }
                }




            }
        }
        return sum(valueStack);
    }

    public static boolean isInteger(String s){
        try{
            Integer.parseInt(s);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    public static int sum(Stack<Integer> s){
        int sum=0;
        while (!s.isEmpty()){
            sum+=s.pop();
        }

        return sum;
    }

}
