class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();

        for(List<String> x : knowledge) {
            map.put(x.get(0), x.get(1));
        }

        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                StringBuilder key = new StringBuilder();
                i++;

                while(s.charAt(i) != ')') {
                    key.append(s.charAt(i));
                    i++;
                }

                ans.append(map.getOrDefault(key.toString(), "?"));
            }
            else {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}