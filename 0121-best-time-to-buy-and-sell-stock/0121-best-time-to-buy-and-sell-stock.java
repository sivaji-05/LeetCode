class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profits =0;
        for(int i=1;i<prices.length;i++){
            int cost= prices[i]-min;
            profits = Math.max(profits,cost);
            min = Math.min(min,prices[i]);
        }
        return profits;
        
    }
}