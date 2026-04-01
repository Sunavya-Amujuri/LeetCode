class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int end=0; end<s.length(); end++){
            char ch = s.charAt(end);
            if(map.containsKey(ch)){
                start = Math.max(start, map.get(ch) + 1);
            }
            map.put(ch, end);
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }
}