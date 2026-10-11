
class Solution {
    boolean dfs(Map<Integer, List<Integer>> map, int i, int parent,
                Set<Integer> visited) {
        if (visited.contains(i))
            return false;

        visited.add(i);

        for (int ele : map.get(i)) {
            if (ele == parent)
                continue;

            if (!dfs(map, ele, i, visited))
                return false;
        }

        return true;
    }

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        if (!dfs(map, 0, -1, visited))
            return false;

        return visited.size() == n;
    }
}
