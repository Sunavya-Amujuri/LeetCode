class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1, maxSpeed = 0;
        for(int p : piles){
            maxSpeed = Math.max(maxSpeed, p);
        }
        while(minSpeed < maxSpeed){
            int mid = (minSpeed + maxSpeed)/2;
            if(canEat(piles, h, mid)){
                maxSpeed = mid;
            } else {
                minSpeed = mid+1;
            }
        }
        return minSpeed;
    }
    public boolean canEat(int[] piles, int h, int mid){
        int hours = 0;
        for(int p : piles){
            hours += (int)Math.ceil((double)p/mid);
        }
        return hours <= h;
    }
}