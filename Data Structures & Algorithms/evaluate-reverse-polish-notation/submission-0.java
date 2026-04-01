class Solution {
        public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "-" -> {
                    int r = stack.pop();
                    int l = stack.pop();
                    stack.push(l - r);
                }
                case "+" -> {
                    int r = stack.pop();
                    int l = stack.pop();
                    stack.push(l + r);
                }
                case "/" -> {
                    int r = stack.pop();
                    int l = stack.pop();
                    stack.push(l / r);
                }
                case "*" -> {
                    int r = stack.pop();
                    int l = stack.pop();
                    stack.push(l * r);
                }
                case null, default -> stack.add(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
