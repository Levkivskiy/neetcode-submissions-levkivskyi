class TimeMap {

    record DbEntry(String value, int timestamp) {
}

    HashMap<String, List<DbEntry>> history;

    public TimeMap() {
        history = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!history.containsKey(key)) {
            history.put(key, new ArrayList<>());
        }
        history.get(key).add(new DbEntry(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<DbEntry> values = history.getOrDefault(key, new ArrayList<>());
        if (values.isEmpty()) return "";
        int L = 0, R = values.size() - 1;
        String res = "";

        while (L <= R) {
            int M = (L + R) / 2;
            if (values.get(M).timestamp <= timestamp) {
                res = values.get(M).value;
                L = M + 1;
            } else {
                R = M - 1;
            }
        }

        return res;
    }
}
