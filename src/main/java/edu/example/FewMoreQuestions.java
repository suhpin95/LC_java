package edu.example;

import java.util.*;

public class FewMoreQuestions {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int numOfUser = username.length;
        Map<String, List<String> > visitedHistory = new HashMap<>();
        for (int i = 0; i < numOfUser; i++) {
            String userName = username[i];
            if (!visitedHistory.containsKey(userName)) {
                visitedHistory.put(userName, new ArrayList<>());
            }
            List<String> put = visitedHistory.get(userName);
            put.add(website[i]);
            visitedHistory.put(userName, put);
        }
        int windowSize = 3;
        // MaxHeap

        Map<List<String>, Integer> freqPattern = new HashMap<>();
        for( List<String> keyVal : visitedHistory.values()){
            for(int i  = 0; i <= keyVal.size() - windowSize; i++ ) {
                List<String> pattern = keyVal.subList(i, i+windowSize);
                freqPattern.put(pattern, freqPattern.getOrDefault(pattern, 0) + 1);
            }
        }
        Queue<Map.Entry<List<String>, Integer>> maxHeap = new PriorityQueue<>((a, b) -> {
            int freqCompare = b.getValue().compareTo(a.getValue());
            if (freqCompare != 0) {
                return freqCompare;
            } else {
                return a.getKey().toString().compareTo(b.getKey().toString());
            }
        });
        maxHeap.addAll(freqPattern.entrySet());
        return maxHeap.peek().getKey();
    }

    public static void main(String[] args) {
        FewMoreQuestions fewMoreQuestions = new FewMoreQuestions();
        String[] userName, website;
        userName = new String[]{"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
        website = new String[] {"home","about","career","home","cart","maps","home","home","about","career"};
        int[] timestamp = new int[] {1,2,3,4,5,6,7,8,9,10};
        fewMoreQuestions.mostVisitedPattern(userName, timestamp, website);
    }
}
