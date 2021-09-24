// graph problem
// if there is a loop in the graph which means a course is dependent whose parents contain this dependent course
// dfs / topological sort
// create a queue
// add the element to the queue
// if at the end we have all the elements in out top sort result then return true else false
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ArrayList<Integer> neighbors = new ArrayList<>();
            graph.put(i, neighbors);
        }
        for (int[] preq : prerequisites) {
            graph.get(preq[1]).add(preq[0]);
            inDegree[preq[0]]++;
        }
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new PriorityQueue();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            if (visited.contains(course)) {
                return false;
            }
            visited.add(course);
            for (int neighbor : graph.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return visited.size() == numCourses;
    }
}