
import java.util.*;

class Solution {

    public boolean makesquare(int[] matchsticks) {

        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }

        int sum = 0;

        for (int stick : matchsticks) {
            sum += stick;
        }

        // Total length must be divisible by 4
        if (sum % 4 != 0) {
            return false;
        }

        int side = sum / 4;

        // Sort in descending order
        Arrays.sort(matchsticks);
        reverse(matchsticks);

        // If largest stick is greater than side length
        if (matchsticks[0] > side) {
            return false;
        }

        int[] sides = new int[4];

        return backtrack(matchsticks, 0, sides, side);
    }

    private boolean backtrack(int[] matchsticks, int index,
                              int[] sides, int target) {

        // All matchsticks are placed
        if (index == matchsticks.length) {
            return true;
        }

        int current = matchsticks[index];

        for (int i = 0; i < 4; i++) {

            // Skip if this side has the same sum as previous side
            if (i > 0 && sides[i] == sides[i - 1]) {
                continue;
            }

            if (sides[i] + current <= target) {

                sides[i] += current;

                if (backtrack(matchsticks, index + 1, sides, target)) {
                    return true;
                }

                // Backtracking
                sides[i] -= current;
            }

            // If current side is empty, no need to try other empty sides
            if (sides[i] == 0) {
                break;
            }
        }

        return false;
    }

    private void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}
