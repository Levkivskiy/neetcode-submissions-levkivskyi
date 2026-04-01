class Solution {
    public int search(int[] nums, int target) {
        int L = 0, R = nums.length - 1;

        while (L <= R) {
            int mid = (L + R) / 2;
            if(nums[mid] > target) {
                R = mid - 1;
            } else if (nums[mid] < target) {
                L = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length - 1;
        int L = 0, R = matrix.length - 1;

        while (L <= R) {
            int mid = (L + R) / 2;
            if(matrix[mid][0] > target) {
                R = mid - 1;
            } else if (matrix[mid][0] <= target && matrix[mid][m] >= target) {
                return search(matrix[mid], target) >= 0;
            } else {
                L = mid + 1;
            }
        }

        return false;
    }
}
