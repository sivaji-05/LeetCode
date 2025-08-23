class Solution {
    public int countPartitions(int[] nums, int k) {
         final int MOD = 1_000_000_007;
    long sum = Arrays.stream(nums).asLongStream().sum();
    if (sum < 2L * k) return 0;

    long ans = modPow(2, nums.length, MOD);
    long[] dp = new long[k + 1];
    dp[0] = 1;

    for (int num : nums) {
      for (int i = k; i >= num; --i) {
        dp[i] = (dp[i] + dp[i - num]) % MOD;
      }
    }

    for (int i = 0; i < k; ++i) {
      if (sum - i < k)
        ans = (ans - dp[i] + MOD) % MOD;
      else
        ans = (ans - dp[i] * 2 % MOD + MOD) % MOD;
    }

    return (int) ans;
  }

  private long modPow(long x, int n, int MOD) {
    long res = 1;
    while (n > 0) {
      if ((n & 1) == 1) res = res * x % MOD;
      x = x * x % MOD;
      n >>= 1;
    }
    return res;
        
    }
}