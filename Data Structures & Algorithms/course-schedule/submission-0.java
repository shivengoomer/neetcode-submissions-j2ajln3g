
class Solution {
    boolean dfs(Map<Integer, List<Integer>> map, int[] visited, int curr) {
        if (visited[curr] == 1) return false; // Cycle detected
        if (visited[curr] == 2) return true;  // Already processed

        visited[curr] = 1; 

        for (int i : map.get(curr)) {
            if (!dfs(map, visited, i))
                return false;
        }

        visited[curr] = 2; // Completely processed
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < numCourses; i++)
            map.put(i, new ArrayList<>());

        for (int[] p : prerequisites)
            map.get(p[1]).add(p[0]);

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(map, visited, i))
                return false;
        }

        return true;
    }
}