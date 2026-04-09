class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String first = strs[0];
        int n = strs.length;

        for (int i = 0; i < first.length(); i++) {
            char ch = first.charAt(i);

            for (int j = 1; j < n; j++) {
                String curr = strs[j];   // store once

                if (i == curr.length() || curr.charAt(i) != ch) {
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }
}