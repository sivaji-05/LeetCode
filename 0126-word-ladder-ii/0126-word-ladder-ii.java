class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!wordSet.contains(endWord)) return res;

        // Step 1: BFS to build parent mapping
        Map<String, List<String>> parents = new HashMap<>();
        Set<String> level = new HashSet<>();
        level.add(beginWord);

        boolean found = false;

        while (!level.isEmpty() && !found) {
            Set<String> nextLevel = new HashSet<>();
            for (String word : level) wordSet.remove(word); // avoid revisiting

            for (String word : level) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String newWord = new String(arr);
                        if (wordSet.contains(newWord)) {
                            nextLevel.add(newWord);
                            parents.computeIfAbsent(newWord, k -> new ArrayList<>()).add(word);
                            if (newWord.equals(endWord)) found = true;
                        }
                    }
                    arr[i] = old;
                }
            }
            level = nextLevel;
        }

        // Step 2: Backtrack to build paths
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            backtrack(endWord, beginWord, parents, path, res);
        }

        return res;
    }

    private void backtrack(String word, String beginWord, Map<String, List<String>> parents,
                           List<String> path, List<List<String>> res) {
        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            res.add(temp);
            return;
        }

        if (!parents.containsKey(word)) return;

        for (String parent : parents.get(word)) {
            path.add(parent);
            backtrack(parent, beginWord, parents, path, res);
            path.remove(path.size() - 1);
        }
    }
}
