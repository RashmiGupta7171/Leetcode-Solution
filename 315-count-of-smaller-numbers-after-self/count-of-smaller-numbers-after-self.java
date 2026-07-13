class Solution {
    private int[] count;
    private int[] indexes;
    private int[] tempIndexes;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        indexes = new int[n];
        tempIndexes = new int[n];

        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, 0, n - 1);

        List<Integer> result = new ArrayList<>();
        for (int c : count) {
            result.add(c);
        }
        return result;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        if (nums[indexes[mid]] <= nums[indexes[mid + 1]]) {
            return;
        }

        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            tempIndexes[i] = indexes[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (nums[tempIndexes[j]] < nums[tempIndexes[i]]) {
                indexes[k++] = tempIndexes[j++];
                rightCount++;
            } else {
                count[tempIndexes[i]] += rightCount;
                indexes[k++] = tempIndexes[i++];
            }
        }

        while (i <= mid) {
            count[tempIndexes[i]] += rightCount;
            indexes[k++] = tempIndexes[i++];
        }

        while (j <= right) {
            indexes[k++] = tempIndexes[j++];
        }
    }
}