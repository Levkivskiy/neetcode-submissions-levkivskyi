class Solution {
    public record Pair(int height, int index) {
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Pair> stack = new Stack<>();

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int currHeight = heights[i];
            if (stack.isEmpty() || stack.peek().height <= currHeight) {
                stack.add(new Pair(currHeight, i));
            } else {
                int startIndex = i;
                while (!stack.isEmpty() && stack.peek().height > currHeight) {
                    Pair stackPair = stack.pop();
                    max = Math.max((i - stackPair.index) * stackPair.height, max);
                    startIndex = stackPair.index;
                }
                stack.add(new Pair(currHeight, startIndex));
            }
        }

        while (!stack.isEmpty()) {
            Pair stackPair = stack.pop();
            max = Math.max((heights.length - stackPair.index) * stackPair.height, max);
        }
        return max;
    }
}
