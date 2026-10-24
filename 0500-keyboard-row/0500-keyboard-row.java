
import java.util.*;

class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm"
        };

        List<String> res = new ArrayList<>();

        for (String word : words) {
            String w = word.toLowerCase();
            int row = rows[0].indexOf(w.charAt(0)) >= 0 ? 0 :
                      rows[1].indexOf(w.charAt(0)) >= 0 ? 1 : 2;

            boolean valid = true;

            for (int i = 1; i < w.length(); i++) {
                if (rows[row].indexOf(w.charAt(i)) == -1) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                res.add(word);
            }
        }

        return res.toArray(new String[0]);
    }
}
