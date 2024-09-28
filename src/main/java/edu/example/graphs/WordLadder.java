package edu.example.graphs;

import java.util.*;

public class WordLadder {
    /*
     *  Given a String originalString and a String target,
     *  find minimum transition required to convert from original-String to target
     */
    Map<String, String> englishDictionary;

    public WordLadder(){
        englishDictionary = new HashMap<>();
    }

    public int getCountForTransition(String originalWord, String target){
        if(originalWord.isEmpty() || target.isEmpty()){
            throw new IllegalArgumentException();
        }
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> visited = new HashMap<>();

        queue.add(originalWord);
        while(!queue.isEmpty()){
            String word = queue.poll();
            if(word.equals(target)){
                return visited.get(word);
            }
            List<String> words = getNeighbors(word);
            for(String neighbor : words){
                if(!visited.containsKey(neighbor)){
                    queue.add(neighbor);
                    visited.put(neighbor, count++);
                }
            }
        }
        return -1;
    }

    private List<String> getNeighbors(String word){
        List<String> neighbors = new ArrayList<>();
        char[] wordArray = word.toCharArray();
        for(int i = 0; i < wordArray.length; i++){
            for(char character = 'a' ; character <= 'z'; character++){
                wordArray[i] = character;
                String newWord = new String(wordArray);
                if(englishDictionary.containsKey(newWord)){
                    neighbors.add(new String(wordArray));
                }
            }
        }
        return neighbors;
    }


}
