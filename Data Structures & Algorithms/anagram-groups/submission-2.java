class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map= new HashMap<>();
        for(String s:strs){
            char[] st= s.toCharArray();
            Arrays.sort(st);
            String sorted= new String(st);
            if(!map.containsKey(sorted)){
                map.put(sorted,new ArrayList<>());
            }
            map.get(sorted).add(s);
        }
        List<List<String>> res= new ArrayList<>();
        for(String s:map.keySet()){
            res.add(map.get(s));
        }
        return res;
    }
}
