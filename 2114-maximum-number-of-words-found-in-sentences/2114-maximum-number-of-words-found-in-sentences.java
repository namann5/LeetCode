class Solution {
    public int mostWordsFound(String[] sentences) {
        int max =0;
        for(String s : sentences){
            int words =1;
            for(char c : s.toCharArray()){
                if(c == ' '){
                    words++;
                }
            }
            max = Math.max(max, words);
        }
        return max;
    }
}