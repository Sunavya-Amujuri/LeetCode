class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // Step 1: Transform string
        String t = "^#";
        for (char c : s.toCharArray()) {
            t += c + "#";
        }
        t += "$";

        int n = t.length();
        int[] p = new int[n];

        int center = 0, right = 0;

        // Step 2: Build p array
        for (int i = 1; i < n - 1; i++) {

            int mirror = 2 * center - i;

            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Expand around center
            while (t.charAt(i + (1 + p[i])) == t.charAt(i - (1 + p[i]))) {
                p[i]++;
            }

            // Update center and right
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        // Step 3: Find max palindrome
        int maxLen = 0;
        int centerIndex = 0;

        for (int i = 1; i < n - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        // Step 4: Extract result
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}