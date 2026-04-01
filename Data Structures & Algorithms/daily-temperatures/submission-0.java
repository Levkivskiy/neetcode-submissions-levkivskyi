class Solution {
    record Temp(int temp, int i) {}

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Temp> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty() || stack.peek().temp >= temperatures[i]) {
                stack.push(new Temp(temperatures[i], i));
            } else {
                while (!stack.isEmpty() && stack.peek().temp < temperatures[i]) {
                    Temp toAdd = stack.pop();
                    res[toAdd.i] = i - toAdd.i;
                }
                stack.push(new Temp(temperatures[i], i));
            }
        }

        while (!stack.isEmpty()) {
            Temp temp = stack.pop();
            res[temp.i] = 0;
        }

        return res;
    }
}
