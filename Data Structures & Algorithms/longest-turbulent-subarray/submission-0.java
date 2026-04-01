class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int max = 1;
        int curr = 1;
        int shouldBeHigher = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == arr[i - 1]) {
                curr = 1;
                shouldBeHigher = 0;
            } else if (shouldBeHigher == 0) {
                curr = 2; // was curr++ (could incorrectly grow from previous)
                shouldBeHigher = (arr[i] > arr[i - 1]) ? -1 : 1; // next should flip
            } else if (shouldBeHigher > 0) { // expect arr[i] > arr[i-1]
                if (arr[i] > arr[i - 1]) {
                    curr++;
                    shouldBeHigher = -1; // flip expectation
                } else {
                    curr = 2;
                    shouldBeHigher = 1;  // because arr[i] < arr[i-1], next should be up
                }
            } else { // shouldBeHigher < 0, expect arr[i] < arr[i-1]
                if (arr[i] < arr[i - 1]) {
                    curr++;
                    shouldBeHigher = 1;  // flip expectation
                } else {
                    curr = 2;
                    shouldBeHigher = -1;
                }
            }

            max = Math.max(max, curr);
        }

        return max;
    }
}