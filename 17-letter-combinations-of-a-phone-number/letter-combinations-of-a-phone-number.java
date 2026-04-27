class Solution {
    public List<String> letterCombinations(String digits) {
         List<String> res = new ArrayList<>();

        if(digits == null || digits.length() == 0)
            return res;

        String[] map = {
                "",     //0
                "",     //1
                "abc",  //2
                "def",  //3
                "ghi",  //4
                "jkl",  //5
                "mno",  //6
                "pqrs", //7
                "tuv",  //8
                "wxyz"  //9
        };

        backtrack(digits, 0, new StringBuilder(), res, map);

        return res;
    }

    public void backtrack(String digits,
                          int index,
                          StringBuilder curr,
                          List<String> res,
                          String[] map) {

        // Base case
        if(index == digits.length()){
            res.add(curr.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for(char ch : letters.toCharArray()){

            curr.append(ch);             // choose

            backtrack(digits,index+1,curr,res,map); // explore

            curr.deleteCharAt(curr.length()-1); // undo (backtrack)
        }
    }
}