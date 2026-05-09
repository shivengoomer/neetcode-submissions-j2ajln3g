class Twitter {

    class Pair {
        int timeStamp;
        int tweetId;

        Pair(int t, int id) {
            this.timeStamp = t;
            this.tweetId = id;
        }
    }

    class UserData {
        List<Pair> tweets;
        Set<Integer> follows;

        UserData() {
            tweets = new ArrayList<>();
            follows = new HashSet<>();
        }
    }

    HashMap<Integer, UserData> users;
    int timeCounter;

    public Twitter() {
        users = new HashMap<>();
        timeCounter = 0;
    }

    private void createUserIfAbsent(int userId) {
        users.putIfAbsent(userId, new UserData());
    }

    public void postTweet(int userId, int tweetId) {
        createUserIfAbsent(userId);

        users.get(userId).tweets.add(new Pair(timeCounter++, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        createUserIfAbsent(userId);

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.timeStamp - a.timeStamp
        );

        for (Pair p : users.get(userId).tweets) {
            pq.offer(p);
        }

        for (int followee : users.get(userId).follows) {
            if (users.containsKey(followee)) {
                for (Pair p : users.get(followee).tweets) {
                    pq.offer(p);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            ans.add(pq.poll().tweetId);
            count++;
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        createUserIfAbsent(followerId);
        createUserIfAbsent(followeeId);

        if (followerId != followeeId) {
            users.get(followerId).follows.add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId)) {
            users.get(followerId).follows.remove(followeeId);
        }
    }
}