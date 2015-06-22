package Others;

import java.util.Stack;

/**
 * Created by Wee on 2015/3/25.
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
    private Stack<Integer> mStack = new Stack<Integer>();
    private Stack<Integer> mMinStack = new Stack<Integer>();

    public void push(int x) {
        mStack.push(x);
        if (mMinStack.size() != 0) {
            int min = mMinStack.peek();
            if (x <= min) {
                mMinStack.push(x);
            }
        } else {
            mMinStack.push(x);
        }
    }

    public void pop() {
        int x = mStack.pop();
        if (mMinStack.size() != 0) {
            if (x == mMinStack.peek()) {
                mMinStack.pop();
            }
        }
    }

    public int top() {
        return mStack.peek();
    }

    public int getMin() {
        return mMinStack.peek();
    }
}
