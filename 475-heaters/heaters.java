import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(heaters);

        int radius = 0;

        for (int house : houses) {

            int index = Arrays.binarySearch(heaters, house);

            if (index >= 0) {
                continue;
            }

            index = -index - 1;

            int left = (index > 0)
                    ? house - heaters[index - 1]
                    : Integer.MAX_VALUE;

            int right = (index < heaters.length)
                    ? heaters[index] - house
                    : Integer.MAX_VALUE;

            int minDistance = Math.min(left, right);

            radius = Math.max(radius, minDistance);
        }

        return radius;
    }
}