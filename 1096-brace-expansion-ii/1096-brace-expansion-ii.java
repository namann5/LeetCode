class Solution {
    TreeSet<String> set = new TreeSet<>();

    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(set);
    }

    void dfs(String exp) {
        int j = exp.indexOf('}');

        // No braces left
        if(j == -1) {
            set.add(exp);
            return;
        }

        // Find matching {
        int i = exp.lastIndexOf('{', j);

        String left = exp.substring(0, i);
        String right = exp.substring(j + 1);

        String[] parts = exp.substring(i + 1, j).split(",");

        for(String part : parts) {
            dfs(left + part + right);
        }
    }
}