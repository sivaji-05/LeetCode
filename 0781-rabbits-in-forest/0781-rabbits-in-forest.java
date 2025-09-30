import java.util.*;

class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int ans : answers) {
            countMap.put(ans, countMap.getOrDefault(ans, 0) + 1);
        }

        int result = 0;
        for (int key : countMap.keySet()) {
            int groupSize = key + 1;
            int count = countMap.get(key);

            int groups = (count + groupSize - 1) / groupSize;
            result += groups * groupSize;
        }

        return result;
    }
}
