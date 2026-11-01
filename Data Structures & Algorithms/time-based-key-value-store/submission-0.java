class TimeMap {

    Map<String, TreeMap<Integer, String>> map = new HashMap<>();

    public TimeMap() {
        map = new HashMap<String, TreeMap<Integer, String>>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> newMap = map.computeIfAbsent(key, (stamp) -> new TreeMap<Integer, String>());
        newMap.put(timestamp, value);
    }

    public String get(String key, int timestamp) {

        TreeMap<Integer, String> item = map.get(key);
        if (item == null) {
            return "";

        }
        Map.Entry<Integer, String> res = item.floorEntry(timestamp);
        return res == null ? "" : res.getValue();
    }
}
