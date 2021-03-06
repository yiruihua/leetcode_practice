//Given a reference of a node in a connected undirected graph. 
//
// Return a deep copy (clone) of the graph. 
//
// Each node in the graph contains a val (int) and a list (List[Node]) of its ne
//ighbors. 
//
// 
//class Node {
//    public int val;
//    public List<Node> neighbors;
//}
// 
//
// 
//
// Test case format: 
//
// For simplicity sake, each node's value is the same as the node's index (1-ind
//exed). For example, the first node with val = 1, the second node with val = 2, a
//nd so on. The graph is represented in the test case using an adjacency list. 
//
// Adjacency list is a collection of unordered lists used to represent a finite 
//graph. Each list describes the set of neighbors of a node in the graph. 
//
// The given node will always be the first node with val = 1. You must return th
//e copy of the given node as a reference to the cloned graph. 
//
// 
// Example 1: 
//
// 
//Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
//Output: [[2,4],[1,3],[2,4],[1,3]]
//Explanation: There are 4 nodes in the graph.
//1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
//2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
//3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
//4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
// 
//
// Example 2: 
//
// 
//Input: adjList = [[]]
//Output: [[]]
//Explanation: Note that the input contains one empty list. The graph consists o
//f only one node with val = 1 and it does not have any neighbors.
// 
//
// Example 3: 
//
// 
//Input: adjList = []
//Output: []
//Explanation: This an empty graph, it does not have any nodes.
// 
//
// Example 4: 
//
// 
//Input: adjList = [[2],[1]]
//Output: [[2],[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= Node.val <= 100 
// Node.val is unique for each node. 
// Number of Nodes will not exceed 100. 
// There is no repeated edges and no self-loops in the graph. 
// The Graph is connected and all nodes can be visited starting from the given n
//ode. 
// 
// Related Topics Depth-first Search Breadth-first Search Graph 
// 👍 1967 👎 1415

package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// 2020-09-07 15:58:10
// Zeshi Yang
public class Leetcode0133CloneGraph{
    // Java: clone-graph
    public static void main(String[] args) {
        Solution sol = new Leetcode0133CloneGraph().new Solution();
        // TO TEST
        
        System.out.println();
    }
//leetcode submit region begin(Prohibit modification and deletion)
// BFS
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = node;
        Node curCopy = new Node(node.val);
        map.put(cur, curCopy);
        bfs(cur, map);
        return curCopy;
    }

    private void bfs(Node cur, HashMap<Node, Node> map) {
        Queue<Node> queue = new LinkedList<>();
        Node curCopy;
        queue.offer(cur);
        while(!queue.isEmpty()) {
            cur = queue.poll();
            curCopy = map.get(cur);
            for (Node neighbor: cur.neighbors) {
                if (map.containsKey(neighbor)) {
                    curCopy.neighbors.add(map.get(neighbor));
                } else {
                    Node neighborCopy = new Node(neighbor.val);
                    map.put(neighbor, neighborCopy);
                    curCopy.neighbors.add(neighborCopy);
                    queue.offer(neighbor);
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// Definition for a Node.
private class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
}