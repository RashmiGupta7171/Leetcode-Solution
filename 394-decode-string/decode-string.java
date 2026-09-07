import java.util.*;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                // Build the repeat number
                num = num * 10 + (ch - '0');

            } else if (ch == '[') {
                // Save current string and repeat count
                countStack.push(num);
                stringStack.push(current);

                // Reset for content inside brackets
                num = 0;
                current = new StringBuilder();

            } else if (ch == ']') {
                // Get repeat count
                int repeat = countStack.pop();

                // Get the string before '['
                StringBuilder previous = stringStack.pop();

                // Repeat current string
                for (int i = 0; i < repeat; i++) {
                    previous.append(current);
                }

                current = previous;

            } else {
                // Normal character
                current.append(ch);
            }
        }

        return current.toString();
    }
}