package algorithm.String;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by qun.chen on 30/5/17.
 */
public class LongestPalindrome {
    private int max;
    private int start;

    public static void main(String[] argv) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.print(longestPalindrome.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        char[] chars = s.toCharArray();

        for(int i=0;i<chars.length;i++){
            expandPalindrome(chars,i,i);
            expandPalindrome(chars,i,i+1);
        }

        return s.substring(start+1,start+max);
    }

    private void expandPalindrome(char[] chars,int left, int right){
        while(left>=0&&right<chars.length){
            if(chars[left]!=chars[right]){
                break;
            }
            left--;
            right++;
        }

        if(right-left>max){
            max=right-left;
            start=left;
        }
    }

    public static class Pair {
        private int left;
        private int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return (this.left == pair.left) && (this.right == pair.right);
        }

        @Override
        public int hashCode() {
            return left + right;
        }
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        char[] chars = s.toCharArray();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, s.length() - 1));

        Set<Pair> visited = new HashSet<>();


        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (!visited.contains(current)) {

                visited.add(current);
                if (check(chars, current.left, current.right)) {
                    return s.substring(current.left, current.right + 1);
                } else {
                    if (current.left <= current.right) {
                        queue.add(new Pair(current.left + 1, current.right));
                        queue.add(new Pair(current.left, current.right - 1));
                    }
                }
            }

        }
        return "";
    }

    private boolean check(char[] chars, int start, int end) {

        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
