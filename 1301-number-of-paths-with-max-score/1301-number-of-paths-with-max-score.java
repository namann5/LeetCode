class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];

        for (int[] row : score)
            Arrays.fill(row, -1);

        score[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;

        int[][] dirs = {{1, 0}, {0, 1}, {1, 1}};

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                char c = board.get(i).charAt(j);

                if (c == 'X' || c == 'S')
                    continue;

                for (int[] d : dirs) {
                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni >= n || nj >= n || score[ni][nj] == -1)
                        continue;

                    if (score[ni][nj] > score[i][j]) {
                        score[i][j] = score[ni][nj];
                        ways[i][j] = ways[ni][nj];
                    } else if (score[ni][nj] == score[i][j]) {
                        ways[i][j] = (ways[i][j] + ways[ni][nj]) % MOD;
                    }
                }

                if (score[i][j] != -1 && Character.isDigit(c)) {
                    score[i][j] += c - '0';
                }
            }
        }

        if (score[0][0] == -1)
            return new int[]{0, 0};

        return new int[]{score[0][0], ways[0][0]};
    }
}