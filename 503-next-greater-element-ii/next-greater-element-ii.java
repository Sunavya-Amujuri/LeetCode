class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[nums.length];
        Stack<Integer> st = new Stack<>();

        // initialize all with -1.
        Arrays.fill(ans, -1);

        for(int i=0; i<2*n; i++){
            int idx = i%n;
            while(!st.isEmpty() && nums[st.peek()] < nums[idx]){
                ans[st.pop()] = nums[idx];
            }
            if(i < n){
                st.push(i);
            }
        }
        return ans;
    }
}