package com.monster.learn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

//6.25%
public class Twitter {

    // <userId, <followerid>>
    private Map<Integer, Set<Integer>> user;
    private LinkedHashSet<Twi> twitters;

    private static class Twi {
        public int tweetId;
        public int userId;
        public Twi(int tweetId, int userId) {
            this.tweetId = tweetId;
            this.userId = userId;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        user = new HashMap<>();
        twitters = new LinkedHashSet<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        twitters.add(new Twi(tweetId, userId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> allShowId = user.get(userId);        
        if (allShowId == null) {
            allShowId = new HashSet<>();
        }
        allShowId.add(userId);
        int nums = 0;
        List<Integer> list = new LinkedList<Integer>();
        LinkedList<Twi> iter = new LinkedList<>(twitters);
        Iterator<Twi> itr = iter.descendingIterator();
        while(itr.hasNext()) {
            Twi twi = itr.next();
            if (allShowId.contains(twi.userId)) {
                list.add(twi.tweetId);
                nums++;
                if (nums == 10) {
                    break;
                }
            }
        }
        return list;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followeeIdList = user.getOrDefault(followerId, new HashSet<Integer>());
        followeeIdList.add(followeeId);
        user.put(followerId, followeeIdList);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followeeIdList = user.getOrDefault(followerId, new HashSet<Integer>());
        if (followeeIdList.contains(followeeId)) {
            followeeIdList.remove(followeeId);
        }
        user.put(followerId, followeeIdList);
    }
}