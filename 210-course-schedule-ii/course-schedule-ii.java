

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Create graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // Step 2: Build graph & indegree
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Step 3: Add nodes with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        // Step 4: BFS
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result[index++] = curr;

            for (int neighbor : graph.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 5: Check if valid
        if (index == numCourses) {
            return result;
        }

        return new int[0]; // cycle detected
    }
}