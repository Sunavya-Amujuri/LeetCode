class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<tokens.length; i++){
            String token = tokens[i];

            if(token.equals("+") || token.equals("-") || 
               token.equals("*") || token.equals("/")){
                int t1 = st.pop();
                int t2 = st.pop();

                int res = 0;

                switch(token){
                    case "+": st.push(t2+t1); break;
                    case "-": st.push(t2-t1); break;
                    case "*": st.push(t2*t1); break;
                    case "/": st.push(t2/t1); break;
                }
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.peek();
    }
}