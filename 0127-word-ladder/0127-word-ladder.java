class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int level = 1;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                String s = q.poll();

                if (s.equals(endWord)) {
                    return level;
                }

                char[] arr = s.toCharArray();

                for (int i = 0; i < arr.length; i++) {

                    char old = arr[i];

                    for (int j = 97; j <= 122; j++) {

                        if (old == (char) j) {
                            continue;
                        }

                        arr[i] = (char) j;

                        String next = new String(arr);

                        if (set.contains(next)) {
                            q.offer(next);
                            set.remove(next);
                        }
                    }

                    arr[i] = old;
                }
            }

            level++;
        }

        return 0;
    }
}