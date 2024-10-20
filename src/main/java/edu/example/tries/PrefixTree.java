package edu.example.tries;

public class PrefixTree {
    private Node root;

    public PrefixTree() {
        this.root = new Node('\0');
    }

    public void insert(String word) {
        Node current = root;
        for (char wordCharacter : word.toCharArray()) {
            int ascii = wordCharacter - 'a';
            if(current.children[ascii] == null) {
                current.children[ascii] = new Node(wordCharacter);
            }
            current = current.children[ascii];
        }
        current.isLeaf = true;
    }

    public boolean search(String word) {
        Node current = getWord(word);
        return current != null && current.isLeaf;
    }

    public boolean startsWith(String prefix) {
        return getWord(prefix) != null;
    }

    private Node getWord(String pattern){
        Node current = root;
        StringBuilder stringBuilder = new StringBuilder();
        for (char wordCharacter : pattern.toCharArray()) {
            int ascii = wordCharacter - 'a';
            if(current.children[ascii] == null) {
                return null;
            }
            stringBuilder.append(wordCharacter);
            current = current.children[ascii];
        }
        String word = stringBuilder.toString();
        System.out.println(word);
        return current;
    }
}
class Node {
    Node[] children;
    char value;
    boolean isLeaf;

    public Node(){
        this.value = 0;
        this.children = new Node[26];
        this.isLeaf = false;
    }
    public Node(char value) {
        this.value = value;
        this.children = new Node[26];
        this.isLeaf = false;
    }
}
