class Solution {
    void dfs(HashMap<Integer,List<Integer>> map , Set<Integer> visited,int i){
        if(visited.contains(i)) return;
        visited.add(i);
        for(int ele:map.get(i)) dfs(map,visited,ele);
    }
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] i:edges){
            map.get(i[0]).add(i[1]);
            map.get(i[1]).add(i[0]);

        }
        HashSet<Integer> visited= new HashSet<>();
        int ct=0;
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                dfs(map,visited,i);
                ct++;
            }
        }
        return ct;
    }
}
