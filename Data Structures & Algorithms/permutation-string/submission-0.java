class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> check = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            check.put(ch, check.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0;
        for (; i < s1.length(); i++) {
            char ch = s2.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        while (i < s2.length()) {
            if (check.equals(map)) return true;
            char add = s2.charAt(i);
            map.put(add, map.getOrDefault(add, 0) + 1);
            i++;
            char rem = s2.charAt(i - s1.length() - 1);
            map.put(rem, map.get(rem) - 1);
            if (map.get(rem) == 0) map.remove(rem);
        }
        return check.equals(map);
    }
}
