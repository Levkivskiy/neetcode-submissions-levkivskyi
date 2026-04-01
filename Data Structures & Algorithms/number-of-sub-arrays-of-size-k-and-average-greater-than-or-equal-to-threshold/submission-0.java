class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int L = 0;
        int avg = 0;
        int count = 0;

        for (int R = 0; R < arr.length; R++) {
            avg += arr[R];
            if (R - L + 1 > k) {
                avg -= arr[L++];
            }
            if (R - L + 1 == k && avg / k >= threshold) {
                count++;
            }
        }

        return count;
    }
}