public class MovingAverage {

    /** Initialize your data structure here. */
    private Queue<Integer> queue;
    private double sum;
    private int size;
    public MovingAverage(int size) {
        this.queue = new LinkedList<Integer>();
        this.size = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        if(queue.size() >= size){
            sum -= queue.poll();
        }
        sum += val;
        queue.offer(val);
        return sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */