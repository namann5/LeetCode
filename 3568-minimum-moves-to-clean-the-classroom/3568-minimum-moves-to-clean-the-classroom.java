class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int[][] id = new int[m][n];

        int sr = 0, sc = 0;
        int litter = 0;

        // Find S and give every L an id
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (classroom[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                }

                if (classroom[i].charAt(j) == 'L') {
                    id[i][j] = litter++;
                }
            }
        }

        if (litter == 0) {
            return 0;
        }

        int totalMask = (1 << litter) - 1;

        // row, col, energy, mask
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{sr, sc, energy, 0});

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litter];

        visited[sr][sc][energy][0] = true;

        int moves = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int[] curr = q.poll();

                int r = curr[0];
                int c = curr[1];
                int e = curr[2];
                int mask = curr[3];

                // All litter collected
                if (mask == totalMask) {
                    return moves;
                }

                // No energy
                if (e == 0) {
                    continue;
                }

                for (int k = 0; k < 4; k++) {

                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n ||
                        classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    int newEnergy = e - 1;

                    // R gives full energy
                    if (classroom[nr].charAt(nc) == 'R') {
                        newEnergy = energy;
                    }

                    int newMask = mask;

                    // Collect litter
                    if (classroom[nr].charAt(nc) == 'L') {
                        newMask = mask | (1 << id[nr][nc]);
                    }

                    if (!visited[nr][nc][newEnergy][newMask]) {

                        visited[nr][nc][newEnergy][newMask] = true;

                        q.add(new int[]{
                            nr, nc, newEnergy, newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}