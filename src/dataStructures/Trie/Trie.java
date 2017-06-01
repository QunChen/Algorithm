package dataStructures.Trie;

/**
 * Created by qun.chen on 19/5/17.
 */
public class Trie<T> {

    public static void main(String[] argv) {
        Trie<Character> trie = new Trie<>();

        Character[] charObjectArray1 ={'h','e','l','l','o'};
        Character[] charObjectArray2 ={'h','e','l','p'};
        Character[] charObjectArray3 ={'h','e','l','l'};
        trie.push(charObjectArray1);
        trie.push(charObjectArray2);
        trie.push(charObjectArray3);

        Character[] charObjectArray4 = {'h','e','p'};
        Character[] charObjectArray5 = {'h','e','l'};

        System.out.println(trie.root.toString());
        System.out.println(trie.search(charObjectArray3));
        System.out.println(trie.search(charObjectArray4));
        System.out.println(trie.search(charObjectArray5));
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode("");
    }

    public void push(T[] list) {

        TrieNode current = root;

        boolean isSub = true;
        for (int i = 0; i < list.length; i++) {
            if (current.children.containsKey(list[i])) {
                current = (TrieNode) current.children.get(list[i]);
            } else {
                buildSub(current, list, i);
                isSub = false;
                break;
            }
        }
        if (isSub) {
            current.isTerminate = true;
        }
    }

    private void buildSub(TrieNode root, T[] list, int curr) {
        for (int i = curr; i < list.length; i++) {
            TrieNode newNode = new TrieNode(list[i]);
            root.children.put(list[i], newNode);
            root = newNode;
            if (i == list.length - 1) {
                newNode.isTerminate = true;
            }
        }
    }


    public boolean search(T[] list){
        TrieNode current = root;
        for (int i = 0; i < list.length; i++) {
            if (current.children.containsKey(list[i])) {
                current = (TrieNode) current.children.get(list[i]);
            } else {
               return false;
            }
        }
        if(current.isTerminate){
            return true;
        }
        return  false;
    }
}
