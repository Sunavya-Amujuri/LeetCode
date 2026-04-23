class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();

        // 1. Skip spaces
        while(i < n && s.charAt(i) == ' '){
            i++;
        }

        // If only spaces
        if(i == n) return 0;

        // 2. Sign
        int sign = 1;

        if(s.charAt(i) == '+' || s.charAt(i) == '-'){
            if(s.charAt(i) == '-'){
                sign = -1;
            }
            i++;
        }

        int result = 0;

        // 3. Read digits
        while(i < n && Character.isDigit(s.charAt(i))){

            int digit = s.charAt(i) - '0';

            // 4. Overflow check
            if(result > Integer.MAX_VALUE/10 ||
              (result == Integer.MAX_VALUE/10 && digit > 7)){

                return (sign == 1)
                        ? Integer.MAX_VALUE
                        : Integer.MIN_VALUE;
            }

            result = result*10 + digit;
            i++;
        }

        return result * sign;
    }
}