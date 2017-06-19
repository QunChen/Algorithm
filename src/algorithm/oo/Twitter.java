package algorithm.oo;

import java.util.*;

/**
 * Created by qun.chen on 16/6/17.
 */
public class Twitter {

    public static void main(String[] argv) {
        Twitter twitter = new Twitter();
        /**
         * ["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed"]
         [[],[1,5],[1,3],[1,101],[1,13],[1,10],[1,2],[1,94],[1,505],[1,333],[1,22],[1,11],[1]]
         */
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 13);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(1, 505);
        twitter.postTweet(1, 333);
        twitter.postTweet(1, 22);

        twitter.unfollow(1, 2);
        twitter.follow(1, 2);
        System.out.println(twitter.getNewsFeed(1));

    }

    private Map<Integer, User> userMap;
    private int timeline;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        userMap = new HashMap<>();
        timeline=0;
    }

    /**
     * as a linked list node for the next tweet
     * increase timeline
     */
    public class Tweet {
        private int id;
        public Tweet next;
        public int timeline;

        public Tweet(int id, int timeline) {
            this.id = id;
            this.timeline = timeline;
        }
    }


    /**
     * a user has a latest tweet as the head node and a set of following users
     */
    public class User {
        private int id;
        public Tweet headTweet;
        public Set<User> following;

        public User(int id) {
            this.id = id;
            following = new HashSet<>();
            follow(this);
        }

        /**
         * make the tweet at the head
         * O(1)
         * @param tweet
         */
        public void postTweet(Tweet tweet) {
            tweet.next = headTweet;
            headTweet = tweet;
        }

        public void follow(User user) {
            following.add(user);
        }

        public void unfollow(User user) {
            following.remove(user);
        }
    }

    ;


    /**
     * Compose a new tweet.
     * increase timeline
     * create new tweet with id and time
     * add new user if null and add to map
     * user post tweet
     * O(1)
     */
    public void postTweet(int userId, int tweetId) {
        timeline++;
        Tweet newTweet = new Tweet(tweetId, timeline);
        User u = userMap.get(userId);
        if (u == null) {
            u = new User(userId);
            userMap.put(userId, u);
        }
        u.postTweet(newTweet);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent.
     *
     * create a queue put newest tweet in front
     * from each following user, retrieve 10 latest news and add to the queue
     * return global 10 latest news
     * O(number of followers)
     */
    public List<Integer> getNewsFeed(int userId) {
        timeline++;
        PriorityQueue<Tweet> queue = new PriorityQueue((o1, o2) -> {
            Tweet t1 = (Tweet) o1;
            Tweet t2 = (Tweet) o2;

            return t2.timeline-t1.timeline;
        });
        User user = userMap.get(userId);
        if (user != null) {
            Iterator<User> iter = user.following.iterator();

            while (iter.hasNext()) {
                User follower = iter.next();
                int size = 10;
                Tweet headTweet = follower.headTweet;
                while (size > 0 && headTweet != null) {
                    queue.offer(headTweet);
                    headTweet = headTweet.next;
                    size--;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int size = 10;

        while (size > 0 && !queue.isEmpty()) {
            Tweet tweet = queue.poll();
            result.add(tweet.id);
            size--;
        }

        return result;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     * increase time
     * if any user not exists, create and add to map
     * add followee
     * O(1)
     */
    public void follow(int followerId, int followeeId) {
        timeline++;
        User u1 = userMap.get(followerId);
        User u2 = userMap.get(followeeId);

        if (u1 == null) {
            u1 = new User(followeeId);
            userMap.put(followerId, u1);
        }

        if (u2 == null) {
            u2 = new User(followeeId);
            userMap.put(followeeId, u2);
        }

        u1.follow(u2);

    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     * remove from set
     */
    public void unfollow(int followerId, int followeeId) {
        timeline++;
        User u1 = userMap.get(followerId);
        User u2 = userMap.get(followeeId);

        if (u1 != null && u2 != null&&u1!=u2) {
            u1.unfollow(u2);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
