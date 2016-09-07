public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new LinkedList<>();
        if(tickets.length == 0) return res;
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for(String[] ticket:tickets){
            map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }
        dfs("JFK", map, res);
        return res;
    }
    
    public void dfs(String pos, HashMap<String, PriorityQueue<String>> map, List<String> res){
        while(map.containsKey(pos) && !map.get(pos).isEmpty()){
            String dest = map.get(pos).poll();
            dfs(dest, map, res);
        }
        res.add(0, pos);
    }
    /*
    非常巧妙的解法，
1. 构建图：因为要找字母表顺序的路径，所以用map套prioriyqueue（用作排序）
2. dfs的时候逆向添加路径。就是持续遍历，直到我们stuck住了，我们的路径就截止了，然后把它加进结果，再往回找之前的环,之前的环上每一个点都可以逆向都可以合并到主路径内。因为一定存在一条合法路径把所有机票都穿起来，所以只有一个地方会stuck，其他的都是环。
例如：
	A->B, A->C, C->A
	先加B stuck，
	往回收C，可以到A，A进去
	然后C进去
	然后A进去，
	逆向就是答案。
    */
}