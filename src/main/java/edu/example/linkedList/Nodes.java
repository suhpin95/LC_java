package edu.example.linkedList;

import java.util.HashMap;
import java.util.Map;

public class Nodes {
    int val;
    Nodes next;
    Nodes random;
    Map<Nodes, Nodes> map = new HashMap<>();

    public Nodes(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Nodes copyRandomList(Nodes head){
        if(head == null){
            return null;
        }
        Nodes current = head;
	    Nodes newNodes = new Nodes(head.val);
        map.put(current, newNodes);
        while(current != null){
            newNodes.next = setReference(current.next);
            newNodes.random = setReference(current.random);
            current = current.next;
            newNodes = newNodes.next;
        }
        return map.get(head);
    }
	public Nodes setReference(Nodes head){
        if(head == null){
            return head;
        }
        if(map.containsKey(head)){
            return map.get(head);
        } else{
            map.put(head, new Nodes(head.val));
            return map.get(head);
        }
    }

//    /**
//     * 287. Find the Duplicate Number
//     * @param nums
//     * @return
//     */
//    public int findDuplicate(int[] nums) {
//
//    }
}
