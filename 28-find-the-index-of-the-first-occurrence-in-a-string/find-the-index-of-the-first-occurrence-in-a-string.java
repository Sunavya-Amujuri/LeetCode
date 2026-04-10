class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        char[] text = haystack.toCharArray();
        char[] pattern = needle.toCharArray();
        char[] newString = new char[text.length + pattern.length + 1];
        int i = 0;
        for(char ch : pattern){
            newString[i++] = ch;
        }
        newString[i++] = '$';
        for(char ch : text){
            newString[i++] = ch;
        }
        int[] z = calculate(newString);
        List<Integer> result = new ArrayList<>();
        for(int j=0; j<z.length; j++){
            if(z[j] == pattern.length){
                return j - pattern.length - 1;
            }
        }
        return -1;
    }
    public static int[] calculate(char[] input){
        int[] z = new int[input.length];
        int l = 0, r = 0;
        for(int k=1; k<input.length; k++){
            if(k > r){
                l = r = k;
                while(r < input.length && input[r] == input[r-l]){
                    r++;
                }
                z[k] = r-l;
                r--;
            } else {
                int k1 = k-l;
                if(z[k1] < r-k+1){
                    z[k] = z[k1];
                }
                else {
                    l = k;
                    while(r < input.length && input[r] == input[r-l]){
                        r++;
                    }
                    z[k] = r-l;
                    r--;
                }
            }
        }
        return z;
    }
}