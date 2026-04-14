class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
            if(!ans.contains(i) && map.get(i)>nums.length/3) ans.add(i);
        }
        return ans;
    }
}