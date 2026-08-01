class Solution {
    public int findJudge(int n, int[][] trust) {
        List<List<Integer>> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lst.add(new ArrayList<>());
        }
        for (int[] t : trust) {
            lst.get(t[1] - 1).add(t[0]);
        }

        for (int i = 0; i < n; i++) {
            if (lst.get(i).size() == n - 1) {
                boolean trustsSomeone = false;
                for (int[] t : trust) {
                    if (t[0] == i + 1) {
                        trustsSomeone = true;
                        break;
                    }
                }
                if (!trustsSomeone) {
                    return i + 1;
                }
            }
        }

        return -1;
    }
}