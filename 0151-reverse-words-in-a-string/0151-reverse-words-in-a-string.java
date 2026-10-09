class Solution {
    public String reverseWords(String s) {
        String trim = s.trim();
        // trim --> "hello.  world"

        String[] arr = trim.split("\\s+");

        int i =0;
        int j = arr.length-1;

        while(i<j){
          String temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
          i++;
          j--;  
        }
        // arr--> hello world
        return String.join(" ", arr); // world hello 
    }
}