// /**
//  * // This is the interface that allows for creating nested lists.
//  * // You should not implement it, or speculate about its implementation
//  * public interface NestedInteger {
//  *
//  *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
//  *     public boolean isInteger();
//  *
//  *     // @return the single integer that this NestedInteger holds, if it holds a single integer
//  *     // Return null if this NestedInteger holds a nested list
//  *     public Integer getInteger();
//  *
//  *     // @return the nested list that this NestedInteger holds, if it holds a nested list
//  *     // Return empty list if this NestedInteger holds a single integer
//  *     public List<NestedInteger> getList();
//  * }
//  */
// public class NestedIterator implements Iterator<Integer> {

//     public NestedIterator(List<NestedInteger> nestedList) {
        
//     }

//     @Override
//     public Integer next() {
        
//     }

//     @Override
//     public boolean hasNext() {
        
//     }
// }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */


 import java.util.*;

public class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        pushList(nestedList);
    }

    private void pushList(List<NestedInteger> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
    }

    @Override
    public Integer next() {
        hasNext();
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger curr = stack.peek();

            if (curr.isInteger()) {
                return true;
            }

            stack.pop();
            pushList(curr.getList());
        }

        return false;
    }
}