class Twitter {

    public record Pair(int tweet, int number) {
    }

    Map<Integer, List<Pair>> tweets = new HashMap<>();
    Map<Integer, Set<Integer>> follow = new HashMap<>();
    int numTweets = 0;

    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {
        List<Pair> currTweets = tweets.get(userId);
        if (currTweets == null) currTweets = new ArrayList<>();

        currTweets.add(new Pair(tweetId, numTweets++));
        tweets.put(userId, currTweets);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Pair> heap = new PriorityQueue<>(Comparator.comparingInt(Pair::number));

        Set<Integer> sources = new HashSet<>(follow.getOrDefault(userId, new HashSet<>()));
        sources.add(userId);

        for (int follow : sources) {
            for (Pair tweet : tweets.getOrDefault(follow, new ArrayList<>())) {
                heap.add(tweet);
                if (heap.size() > 10) heap.poll();
            }
        }

        List<Integer> res = new ArrayList<>();

        while (!heap.isEmpty()) {
            res.add(heap.poll().tweet);
        }

        Collections.reverse(res);
        return res;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> followers = follow.getOrDefault(followerId, new HashSet<>());
        followers.add(followeeId);

        follow.put(followerId, followers);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followers = follow.getOrDefault(followerId, new HashSet<>());
        followers.remove(followeeId);

        follow.put(followerId, followers);
    }
}
