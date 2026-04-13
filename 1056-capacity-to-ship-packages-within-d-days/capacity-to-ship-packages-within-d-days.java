class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for(int w : weights){
            low = Math.max(low, w);
            high += w;
        }
        while(low <= high){
            int mid = (low+high)/2;
            if(canShip(weights, days, mid)){
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean canShip(int[] weights, int days, int capacity){
        int daysUsed = 1;
        int currentWeight = 0;
        for(int w : weights){
            if(currentWeight + w > capacity){
                daysUsed++;
                currentWeight = w;
            } else {
                currentWeight += w;
            }
        }
        return daysUsed <= days;
    }
}