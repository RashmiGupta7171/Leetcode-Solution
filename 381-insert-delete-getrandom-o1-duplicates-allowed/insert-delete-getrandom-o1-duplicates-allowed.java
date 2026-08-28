
class RandomizedCollection {

    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random random;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean notPresent = !map.containsKey(val);

        // Add value to list
        list.add(val);

        // Add its index to the set
        map.computeIfAbsent(val, k -> new HashSet<>())
           .add(list.size() - 1);

        return notPresent;
    }

    public boolean remove(int val) {

        // Value doesn't exist
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }

        // Get any index of val
        Set<Integer> indices = map.get(val);
        int removeIndex = indices.iterator().next();

        // Last element in the list
        int lastIndex = list.size() - 1;
        int lastValue = list.get(lastIndex);

        // Remove the index of val
        indices.remove(removeIndex);

        // If removing something other than the last element,
        // move the last element into removeIndex
        if (removeIndex != lastIndex) {

            list.set(removeIndex, lastValue);

            // Update lastValue's index
            Set<Integer> lastValueIndices = map.get(lastValue);
            lastValueIndices.remove(lastIndex);
            lastValueIndices.add(removeIndex);
        }

        // Remove last element from list
        list.remove(lastIndex);

        // If no occurrences remain, remove val from map
        if (indices.isEmpty()) {
            map.remove(val);
        }

        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */