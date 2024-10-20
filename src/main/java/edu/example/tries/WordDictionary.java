package edu.example.tries;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    Node root;

    public WordDictionary() {
        this.root = new Node('\0');
    }

    public void addWord(String word) {
        Node curr = this.root;
        for (char wordCharacter : word.toCharArray()) {
            if(!curr.children.containsKey(wordCharacter)) {
                curr.children.put(wordCharacter, new Node(wordCharacter));
            }
            curr = curr.children.get(wordCharacter);
        }
        curr.isLeaf = true;
    }

    public boolean search(String word) {
        return dfs(word, this.root);
    }
    private boolean dfs(String pattern, Node node){
        for(int i=0; i < pattern.length(); i++){
            char wordCharacter = pattern.charAt(i);
            if(!node.children.containsKey(wordCharacter)){
                if(wordCharacter == '.'){
                    for(char child : node.children.keySet()){
                        Node children = node.children.get(child);
                        if(dfs(pattern.substring(i+1), children)){
                            return true;
                        }
                    } // for
                } // if
                return false;
            } else {
                node = node.children.get(wordCharacter);
            } // else

        }
        return node.isLeaf;
    }

    private class Node{
        Character value;
        Map<Character,Node> children;
        boolean isLeaf;

        public Node(Character value){
            this.value = value;
            this.children = new HashMap<>();
            this.isLeaf = false;
        }
    }

}
