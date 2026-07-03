class Solution {
    public int findKthLargest(int[] arr, int k) {
       int n = arr.length;
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        int i;
        
        for(i=0;i<arr.length;i++){
            pq.add(arr[i]);
        
        
       
            if(pq.size() > k){
                //continue;
                pq.poll();
               // pq.add(arr[i]);
            }
        }
        return pq.peek();
    }
}