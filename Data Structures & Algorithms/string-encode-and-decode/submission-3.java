class Solution {
    public String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();

        for (String str : strs) {
            ans.append(str);
            ans.append("tada#");
        }

        return ans.toString();
    }

    public List<String> decode(String str) {
        String[] resArray = str.split("tada#", -1);
        List<String> ans = new ArrayList<>();
        for (String s : resArray) {
            ans.add(s);
        }
        ans.remove(ans.size() - 1);

        return ans;
    }
}