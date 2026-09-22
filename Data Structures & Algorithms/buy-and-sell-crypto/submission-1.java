class Solution {
    public int maxProfit(int[] prices) {
        int maxPr=0;
        int minPrice=prices[0];
        for(int i=0;i<prices.length;i++){
            minPrice=Math.min(minPrice,prices[i]);
            maxPr=Math.max(maxPr,prices[i]-minPrice);
        }
        return maxPr;
    }
}
