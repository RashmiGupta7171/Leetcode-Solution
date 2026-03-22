class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 10) return result;
    Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        Set<Integer> seen = new HashSet<>();
        Set<Integer> added = new HashSet<>();

        int hash = 0;

        for (int i = 0; i < 10; i++) {
            hash = (hash << 2) | map.get(s.charAt(i));
        }
        seen.add(hash);

        int mask = (1 << 20) - 1; 
        for (int i = 10; i < s.length(); i++) {
            hash = ((hash << 2) | map.get(s.charAt(i))) & mask;

            if (seen.contains(hash)) {
                if (!added.contains(hash)) {
                    result.add(s.substring(i - 9, i + 1));
                    added.add(hash);
                }
            } else {
                seen.add(hash);
            }
        }

        return result;
    }
}