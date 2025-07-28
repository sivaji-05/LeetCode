class Solution {
    private static final long MOD = 1_000_000_007; 

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2; 
        long oddPositions = n / 2; 

        long goodEven = power(5, evenPositions); 
        long goodOdd = power(4, oddPositions); 

        return (int)((goodEven * goodOdd) % MOD);
    }

    
    private long power(long base, long exp) {
        long result = 1;
        base = base % MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {         
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;   
            exp >>= 1;                    
        }

        return result;
    }
}
