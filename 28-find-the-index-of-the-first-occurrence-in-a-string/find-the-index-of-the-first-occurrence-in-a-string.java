class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        int lps[] = buildLps(needle);
        int i = 0, j = 0;

        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            if(j == needle.length()){
                return i-j;
            } else if (i < haystack.length() && haystack.charAt(i) != needle.charAt(j)){
                if(j != 0){
                    j = lps[j-1];
                } else {
                    i++;
                }
            } 
        }
        return -1;
    }
    static int[] buildLps(String needle){
        int n = needle.length();
        int[] lps = new int[n];
        int len = 0, i = 1;

        while(i < n){
            if(needle.charAt(len) == needle.charAt(i)){
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len != 0){
                    len = lps[len-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            } 
            
        }
        return lps;
    }
}