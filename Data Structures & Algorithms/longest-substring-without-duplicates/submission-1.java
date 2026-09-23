class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        HashSet<Character> set = new HashSet<>();
        int res = 0;

        while (end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
                res = Math.max(res, set.size());
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }

        return res;
    }
}