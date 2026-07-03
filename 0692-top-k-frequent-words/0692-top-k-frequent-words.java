class Solution {
    class Pair {
        String num;
        int freq;

        Pair(String num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        

       PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
             if (a.freq == b.freq) {
            return b.num.compareTo(a.num);
            }   
            return a.freq - b.freq;
        });
        HashMap <String,Integer> map = new HashMap<>();

        for(String ch  : words){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        for(String x : map.keySet()){
           Pair cur = new Pair(x, map.get(x));

            if(pq.size() < k){
                pq.offer(cur);
            }
            else if (cur.freq > pq.peek().freq ||
              (cur.freq == pq.peek().freq &&
               cur.num.compareTo(pq.peek().num) < 0)) {

                 pq.poll();
                pq.offer(cur);
            }
        }

            List<String> res = new ArrayList<>();
            while (!pq.isEmpty()) {
             res.add(pq.poll().num);
            }
            Collections.reverse(res);


            return res;
        
    }
}