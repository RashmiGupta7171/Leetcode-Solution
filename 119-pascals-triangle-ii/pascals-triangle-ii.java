class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        List <Integer> al = new ArrayList<>();
        al.add(1);
        list.add(new ArrayList<>(al));
        al.add(1);
        list.add(new ArrayList<>(al));

        for( int i = 2; i <= rowIndex; i++){
            List<Integer> prev = list.get(i - 1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for(int j = 0; j < prev.size() - 1; j++){
                curr.add(prev.get(j) + prev.get(j + 1));
                }
                curr.add(1);
                list.add(new ArrayList<>(curr));
            }
            return list.get(rowIndex);
    }
}