class Twitter {

    private Map<Integer, Set<Integer>> followMap;

    private Map<Integer, List<Tweet>> tweetMap;

    private int time;

    private static class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> b.time - a.time
        );

        if (tweetMap.containsKey(userId)) {
            pq.addAll(tweetMap.get(userId));
        }
        if (followMap.containsKey(userId)) {
            for (int followeeId : followMap.get(userId)) {
                if (tweetMap.containsKey(followeeId)) {
                    pq.addAll(tweetMap.get(followeeId));
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty() && result.size() < 10) {
            result.add(pq.poll().tweetId);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId) {
            return;
        }

        followMap.putIfAbsent(followerId, new HashSet<>());

        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}