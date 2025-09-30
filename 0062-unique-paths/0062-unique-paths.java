class Solution {
    public int uniquePaths(int m, int n) {
        long result = 1;
        int totalMoves = m + n - 2;
        int downMoves = m - 1;

        for (int i = 1; i <= downMoves; i++) {
            result = result * (totalMoves - downMoves + i) / i;
        }

        return (int) result;
    }
}
