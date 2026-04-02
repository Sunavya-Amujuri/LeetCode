class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i=0; i<n; i++){
            int val = prefix[i] - k;
            if(map.containsKey(val)){
                count += map.get(val);
            }
            map.put(prefix[i], map.getOrDefault(prefix[i], 0)+ 1);
        }
        return count;
    }
}