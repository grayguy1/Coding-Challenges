class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        final int fLen = firstList.length;
        final int sLen = secondList.length;
        int i = 0;
        int j = 0;
        ArrayList<int[]> result = new ArrayList<>();
        while (i < fLen && j < sLen) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            if (start <= end) {
                int[] arr = new int[]{start, end};
                result.add(arr);
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            }
            else {
                j++;
            }
        }
        int[][] res = new int[result.size()][2];
        for (i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}