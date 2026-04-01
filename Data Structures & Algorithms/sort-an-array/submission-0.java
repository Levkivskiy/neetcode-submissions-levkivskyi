class Solution {
    int[] nums;

    public int[] sortArray(int[] nums) {
        this.nums = nums;
        mergeSort(0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(l, m);
            mergeSort(m + 1, r);
            merge(l, m, r);
        }
    }

    public void merge(int l, int m, int r) {
        int leftSize = m - l + 1;
        int rightSize = r - m;

        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArr[i] = nums[i + l];
        }
        for (int i = 0; i < rightSize; i++) {
            rightArr[i] = nums[i + m + 1];
        }

        int leftIter = 0;
        int rightIter = 0;
        int arrIter = l;
        while (leftIter < leftSize && rightIter < rightSize) {
            if (leftArr[leftIter] <= rightArr[rightIter]) {
                nums[arrIter++] = leftArr[leftIter++];
            } else {
                nums[arrIter++] = rightArr[rightIter++];
            }
        }

        while (leftIter < leftSize) {
            nums[arrIter++] = leftArr[leftIter++];
        }
        while (rightIter < rightSize) {
            nums[arrIter++] = rightArr[rightIter++];
        }
    }
}