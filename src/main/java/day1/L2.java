package day1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * <p>
 */
public class L2 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());//-3
        minStack.pop();
        System.out.println(minStack.top());//0
        System.out.println(minStack.min());//-2

    }

    static class Node<E> {
        E item;
        Node<E> next;
        E min;

        Node(E element, Node<E> next, E min) {
            this.item = element;
            this.next = next;
            this.min = min;
        }
    }

    static class MinStack {
        transient Node<Integer> top;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
        }

        //压栈
        public void push(int x) {
            if (top == null) {
                top = new Node<>(x, null, x);
            } else {
                top = new Node<>(x, top, Math.min(top.min, x));
            }
        }

        //出栈
        public void pop() {
            top = top.next;
        }

        //栈顶
        public int top() {
            return top.item;
        }

        // 最小值
        public int min() {
            return top.min;
        }
    }
}
