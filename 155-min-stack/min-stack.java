class MinStack {
    Stack<Long> st;
    long minVal;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push((long) val);
            minVal = val;
        } else {
            if(val < minVal){
                st.push(2L * val - minVal);
                minVal = val;
            } else {
                st.push((long) val);
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;

        long top = st.pop();
        if(top < minVal){
            minVal = 2L*minVal-top;
        }
    }
    
    public int top() {
        long top = st.peek();

        if(top < minVal){
            return (int)minVal;
        }
        return (int)top;
    }
    
    public int getMin() {
        return (int)minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */