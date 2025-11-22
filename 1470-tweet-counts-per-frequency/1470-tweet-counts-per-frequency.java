class TweetCounts {
    private Map<String, List<Integer>> tweetMap;

    public TweetCounts() {
        tweetMap = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        tweetMap.putIfAbsent(tweetName, new ArrayList<>());
        tweetMap.get(tweetName).add(time);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int interval = 0;
        if (freq.equals("minute")) {
            interval = 60;
        } else if (freq.equals("hour")) {
            interval = 3600;
        } else if (freq.equals("day")) {
            interval = 86400;
        }

        int n = ((endTime - startTime) / interval) + 1;
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, 0));

        if (!tweetMap.containsKey(tweetName)) return result;

        for (int time : tweetMap.get(tweetName)) {
            if (time >= startTime && time <= endTime) {
                int index = (time - startTime) / interval;
                result.set(index, result.get(index) + 1);
            }
        }

        return result;
    }
}