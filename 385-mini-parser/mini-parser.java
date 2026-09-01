/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 public class Solution {

    public NestedInteger deserialize(String s) {

        // If the string is just an integer
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        // Create an empty list
        NestedInteger result = new NestedInteger();

        int num = 0;
        int sign = 1;
        boolean hasNum = false;

        for (int i = 1; i < s.length() - 1; i++) {

            char ch = s.charAt(i);

            // Handle negative sign
            if (ch == '-') {
                sign = -1;
            }

            else if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
                hasNum = true;
            }

            else if (ch == ',') {

                if (hasNum) {
                    result.add(new NestedInteger(sign * num));
                    num = 0;
                    sign = 1;
                    hasNum = false;
                }
            }

            else if (ch == '[') {

                int start = i;
                int count = 1;

                while (count != 0) {
                    i++;

                    if (s.charAt(i) == '[') {
                        count++;
                    } else if (s.charAt(i) == ']') {
                        count--;
                    }
                }

                result.add(deserialize(s.substring(start, i + 1)));

                num = 0;
                sign = 1;
                hasNum = false;
            }
        }

        if (hasNum) {
            result.add(new NestedInteger(sign * num));
        }

        return result;
    }
}