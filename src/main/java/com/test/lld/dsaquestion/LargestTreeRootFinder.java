package com.test.lld.dsaquestion;

import java.util.HashMap;
import java.util.Map;

public class LargestTreeRootFinder {

	/*
	 * 
	 * A forest is represented with a hashmap. 
	 * This hashmap has this key -> value relationship: child -> parent.
	 * Every node has a unique integer element. 
	 * I needed to find out the largest tree's root node. If there is a tie, 
	 * return the smallest root.
	 * The tree with the highest number of nodes, is the largest one. 
	 * The edges are directed from parent to child.
	 * 
	 * 
	 * Input:   {{1 -> 2}, {3 -> 4}}
	 * 
	 * Output : 2
	 * */
	
	public static void main(String[] args) {
		
		Map<Integer, Integer> forest = new HashMap<>();
        forest.put(1, 2);
        forest.put(3, 4);

        int largestRoot = findLargestTreeRoot(forest);
        System.out.println("Largest tree root: " + largestRoot);  // Output: 2
	}
	
	public static int findLargestTreeRoot(Map<Integer, Integer> childToParent) {
        Map<Integer, Integer> rootToCount = new HashMap<>();

        for (Integer child : childToParent.keySet()) {
            int root = findRoot(child, childToParent);
            rootToCount.put(root, rootToCount.getOrDefault(root, 0) + 1);
        }

        // Include nodes that are roots themselves (i.e., not children of any node)
        for (Integer node : childToParent.values()) {
            if (!childToParent.containsKey(node)) {
                rootToCount.putIfAbsent(node, 1); // single-node tree
            }
        }

        // Find the root with the largest count (smallest if tie)
        int maxCount = 0;
        int resultRoot = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : rootToCount.entrySet()) {
            int root = entry.getKey();
            int count = entry.getValue();
            if (count > maxCount || (count == maxCount && root < resultRoot)) {
                maxCount = count;
                resultRoot = root;
            }
        }

        return resultRoot;
    }

    private static int findRoot(int node, Map<Integer, Integer> map) {
        while (map.containsKey(node)) {
            node = map.get(node);
        }
        return node;
    }
}
