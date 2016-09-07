public class SnakeGame {
    private HashSet<Integer> set;
    private Deque<Integer> queue;
    private int width;
    private int height;
    private int length;
    private int[][] food;
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.length = 0;
        set = new HashSet<>();
        queue = new LinkedList<>();
        queue.offerFirst(0);
        this.food = food;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int x = queue.peekLast() / width;
        int y = queue.peekLast() % width;
        switch(direction){
            case "U": x--; break;
            case "L": y--; break;
            case "R": y++; break;
            case "D": x++; break;
        }
        int next = x * width + y;
        if(x < 0 || y < 0 || x == height || y == width){
            return -1;
        }
        int[] curFood = null;
        if(length < food.length){
            curFood = food[length];
        }
        
        if(curFood != null && x == curFood[0] && y == curFood[1]){
            length++;
        }
        else {
            int old = queue.pollFirst();
            set.remove(old);
        }
        if(set.contains(next)) return -1;
        set.add(next);
        queue.offerLast(next);
        return length;
    }
    /*
    deque + hashset
注意一定要先去除最老的，在判断是否next在hashset里，因为有可能next曾经是最老的。注意当food没有了的时候，一定要保证蛇能继续移动，继续返回蛇的长度。蛇的长度不包括蛇头

    */
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */