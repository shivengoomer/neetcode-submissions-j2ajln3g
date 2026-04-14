class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxCt = 0;
        int i = 0, j = 0; // two pointers

        while (j < s.length()) {
            char ch = s.charAt(j);
            if (!set.contains(ch)) {
                set.add(ch);
                maxCt = Math.max(maxCt, set.size());
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return maxCt;
    }
}
