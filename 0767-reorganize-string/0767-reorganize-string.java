class Solution {

    class Pair {
        char letter;
        int freq;

        Pair(char letter, int freq){
            this.letter = letter;
            this.freq = freq;
        }
    };

    public String reorganizeString(String s) {

        //count and store frequencies of each character 
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        //make a comparator for max heap storage
        Comparator<Pair> comparator = (a, b) -> {
            return b.freq - a.freq;
        };


        //insert all pairs {letter, freq} into max heap
        //pop top 2 out 
        //append them in answer
        //pop top two out and repeat
       
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Pair> pq = new PriorityQueue<>(comparator);

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.offer(new Pair (entry.getKey(), entry.getValue()));
       }

        while(pq.size() >= 2){
                Pair firstPoll = pq.poll();
                Pair secondPoll = pq.poll();

                sb.append(firstPoll.letter);
                sb.append(secondPoll.letter);

                firstPoll.freq--;
                secondPoll.freq--;

                if(firstPoll.freq > 0){
                    pq.offer(firstPoll);
                }
                if(secondPoll.freq > 0){
                    pq.offer(secondPoll);
                }
            }

            //if a single pair is still left in the heap -> 2 cases
            if(!pq.isEmpty()){

                //poll this last pair 
                Pair lastPoll = pq.poll();

                //if the last pair has a single frequency -> append it\
                if(lastPoll.freq > 1){
                    return "";
                }

                if(sb.length() > 0 && sb.charAt(sb.length()-1) == lastPoll.letter){
                    return "";
                }
                //else
                sb.append(lastPoll.letter);
            }

    return sb.toString();
    }
}