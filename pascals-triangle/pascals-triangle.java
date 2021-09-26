class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> level = new ArrayList<>();
            level.add(1);
            for (int j = 0; j < i - 1; j++) {
                level.add(triangle.get(i - 1).get(j) + triangle.get(i - 1).get(j + 1));
            }
            if (i != 0) {
                level.add(1);
            }
            triangle.add(level);
        }
        return triangle;
    }
}