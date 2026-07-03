class Solution {
    class Pair {
        int num;
        int freq;

        Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        

        PriorityQueue <Pair> pq = new PriorityQueue<>((a,b) -> a.freq -  b.freq);

        HashMap <Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(int x : map.keySet()){
           Pair cur = new Pair(x, map.get(x));

            if(pq.size() < k){
                pq.offer(cur);
            }
            else if(cur.freq > pq.peek().freq){
                pq.poll();
                pq.offer(cur);
            }
        }

            int[] res = new int[k];
            int idx = k-1;

            while(!pq.isEmpty()){
                res[idx--] = pq.poll().num;
               
            }
        
        return res;
    }
}