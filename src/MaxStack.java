import java.util.Stack;

class MaxStack {
    Stack<Integer> numstack;
    Stack<Integer> maxstack;
    /** initialize your data structure here. */
    public MaxStack() {
        numstack = new Stack<>();
        maxstack = new Stack<>();
    }

    public void push(int x) {
        numstack.push(x);
        if (!maxstack.isEmpty() && x<=maxstack.peek()){
            maxstack.push(maxstack.peek());
        }else {
            maxstack.push(x);
        }
    }

    public int pop() {
        maxstack.pop();
        return numstack.pop();
    }

    public int top() {
        return numstack.peek();
    }

    public int peekMax() {
        return maxstack.peek();
    }

    public int popMax() {
        int maxvalue = maxstack.peek();

        Stack<Integer> temp = new Stack<>();
        while (numstack.peek() != maxvalue){
            temp.add(numstack.pop());
            maxstack.pop();
        }

        pop();

        while (!temp.isEmpty()){
            push(temp.pop());
        }



        return maxvalue;
    }
}
