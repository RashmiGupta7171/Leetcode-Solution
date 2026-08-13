
class Twitter {

    // Stores: userId -> set of users they follow
    private Map<Integer, Set<Integer>> followMap;

    // Stores: userId -> list of tweets
    private Map<Integer, List<Tweet>> tweetMap;

    // Used to determine which tweet is more recent
    private int time;

    // Tweet class
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
        // Create tweet list for user if it doesn't exist
        tweetMap.putIfAbsent(userId, new ArrayList<>());

        // Add tweet with current timestamp
        tweetMap.get(userId).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {

        // Max heap: most recent tweet comes first
        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> b.time - a.time
        );

        // Add user's own tweets
        if (tweetMap.containsKey(userId)) {
            pq.addAll(tweetMap.get(userId));
        }

        // Add tweets from followed users
        if (followMap.containsKey(userId)) {
            for (int followeeId : followMap.get(userId)) {
                if (tweetMap.containsKey(followeeId)) {
                    pq.addAll(tweetMap.get(followeeId));
                }
            }
        }

        // Get maximum 10 recent tweets
        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty() && result.size() < 10) {
            result.add(pq.poll().tweetId);
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        // A user cannot follow themselves
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