class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();

        // frequency of characters in t
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int required = map.size();
        int formed = 0;

        HashMap<Character, Integer> window = new HashMap<>();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (map.containsKey(c) && window.get(c).intValue() == map.get(c).intValue()) {
                formed++;
            }

            // shrink window
            while (left <= right && formed == required) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char ch = s.charAt(left);
                window.put(ch, window.get(ch) - 1);

                if (map.containsKey(ch) && window.get(ch) < map.get(ch)) {
                    formed--;
                }

                left++;
            }
            right++;
        }

        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(start, start + minLen);
    }
}