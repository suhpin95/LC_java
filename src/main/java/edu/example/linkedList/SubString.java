package edu.example.linkedList;

import java.util.*;

public class SubString {
    String result = null;
    Map<String, Nodes> nodeMap = new HashMap<String, Nodes>();
    LinkedList<String> list = new LinkedList();
    public String getShortestWord(String doc, HashSet<String> dictionary) {
        WordIterator wi = new WordIterator(doc);
        while (wi.hasNext()) {
            WordIndex wordIndex = wi.next();
            String word = wordIndex.getWord();
            if (!dictionary.contains(word)) {
                continue;
            }
            if(dictionary.contains(word)) {
                String keyToDelete = dictionary.stream().filter(key-> key == word).toString();
                dictionary.remove(keyToDelete);
            }
        }
        return "";
    }
}
class Node {
    Nodes head;
    Nodes tail;
    String data;
    int index;
}
class WordIterator implements Iterator<WordIndex> {
    String string;
    int position;

    public WordIterator(String string) {
        this.string = string.trim();
        position = 0;
        addToNextAlphabet();
    }
    private void addToNextAlphabet(){
        while (position < string.length() && !!Character.isLetter(string.charAt(position))){
            position++;
        }
    }
    @Override
    public boolean hasNext() {
        return position < string.length();
    }

    @Override
    public WordIndex next() {
        if(!hasNext()){
            return null;
        }
        int wordStartIndex = position;
        addToNextAlphabet();
        int wordEndIndex = position - 1;
        return new WordIndex(string.substring(wordStartIndex, wordEndIndex + 1), wordStartIndex);
    }
}
class WordIndex{
    String word;
    int index;
    public WordIndex(String word, int index) {
        this.word = word;
        this.index = index;
    }

    public String getWord() {
        return word;
    }

    public int getIndex() {
        return index;
    }
}