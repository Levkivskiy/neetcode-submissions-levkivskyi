class Solution {
    public record Pair(int earn, int capital) {
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Pair> byCapital = new PriorityQueue<>(Comparator.comparingInt(Pair::capital));
        PriorityQueue<Pair> canBuy = new PriorityQueue<>(Comparator.comparingInt(Pair::earn).reversed());


        for (int i = 0; i < profits.length; i++) {
            byCapital.offer(new Pair(profits[i], capital[i]));
        }

        int sum = w;

        while (k != 0) {
            while (!byCapital.isEmpty() && byCapital.peek().capital <= sum) {
                canBuy.offer(byCapital.poll());
            }
            if(canBuy.isEmpty()) {
                break;
            }
            Pair pair = canBuy.poll();
            sum += pair.earn;
            k--;
        }

        return sum;
    }
}