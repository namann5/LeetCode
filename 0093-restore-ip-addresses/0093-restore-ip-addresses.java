class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(String s, int idx, List<String> path) {

        if (path.size() == 4) {
            if (idx == s.length()) {
                ans.add(String.join(".", path));
            }
            return;
        }

        for (int len = 1; len <= 3 && idx + len <= s.length(); len++) {

            String part = s.substring(idx, idx + len);

            if (part.length() > 1 && part.charAt(0) == '0') {
                continue;
            }

            int num = Integer.parseInt(part);

            if (num > 255) {
                continue;
            }

            path.add(part);
            backtrack(s, idx + len, path);
            path.remove(path.size() - 1);
        }
    }
}