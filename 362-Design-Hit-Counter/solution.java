public class HitCounter {
    private final static int TIME_LIMITATION = 300;
    private Deque<TimeAndNumPair> queue;
    private int size;
    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new LinkedList<TimeAndNumPair>();
        size = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(!queue.isEmpty() && queue.peekLast().time == timestamp){
            queue.peekLast().num++;
        }
        else {
            queue.offerLast(new TimeAndNumPair(timestamp));
            if(timestamp - queue.peekFirst().time >= TIME_LIMITATION){
                size -= queue.pollFirst().num;
            }
        }
        size++;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!queue.isEmpty() && (timestamp - queue.peekFirst().time >= TIME_LIMITATION)){
            size -= queue.pollFirst().num;
        }
        return size;
    }
    class TimeAndNumPair {
        int time;
        int num;
        public TimeAndNumPair(int time){
            this.time = time;
            this.num = 1;
        }
    }
    /*
    用Deque做，整体思路是用一个TimeAndNumPair来保留time 和当前有多少request 同时到来（num）。在hit的时候同时去掉最开始过期的，这样可以保证queue的size永远不超过300；
在gethit的时候去掉过期的。得出最终的size
    */
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */