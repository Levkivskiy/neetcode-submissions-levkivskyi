class Solution {
    public int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
        int rightMost = -1;

        for (int i = arr.length - 1; i >= 0; i--) {
            res[i] = rightMost;
            rightMost = Math.max(rightMost, arr[i]);
        }

        return res;
    }
}