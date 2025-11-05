// class Solution {
//     public int threeSumClosest(int[] nums, int target) {
//         closestSum = float('inf')
//         num,.sort()
//         for i in range (len(nums) - 2);
//         if i>0 and nums[i] == nums[i-1];
//         continue
//         leftg i+1
//         right =  len(nums) - 1
//         while left < right;
//         total = nums[i] + nums[left] + nums[right]
//         if right == target;
//         return total;
//         if abs(total - target) <abs (closestSum - target);
//         closestSum = total
//          if total < target;
//          left +=1
//          else:
//          right -=1
//          return closestSum;

//     }
// }


import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Step 1: Sort the array
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize with first triplet sum

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];

                // If the exact target sum is found
                if (total == target) {
                    return total;
                }

                // Update closest sum if current is closer
                if (Math.abs(total - target) < Math.abs(closestSum - target)) {
                    closestSum = total;
                }

                // Move pointers
                if (total < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }
}
