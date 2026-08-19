class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (col >= 2 && col <= 9) {
                map.put(row, map.getOrDefault(row, 0) | (1 << col));
            }
        }

        int ans = (n - map.size()) * 2;

        for (int mask : map.values()) {

            boolean left = (mask & 60) == 0;   // 2,3,4,5
            boolean right = (mask & 960) == 0; // 6,7,8,9
            boolean middle = (mask & 240) == 0; // 4,5,6,7

            if (left && right) {
                ans += 2;
            } else if (left || middle || right) {
                ans++;
            }
        }

        return ans;
    }
}