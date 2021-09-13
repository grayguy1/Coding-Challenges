class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long maxHorizontalCut = 0;
        int prevH = 0;
        for (int i = 0; i < horizontalCuts.length; i++) {
            maxHorizontalCut = Math.max(maxHorizontalCut, horizontalCuts[i] - prevH);
            prevH = horizontalCuts[i];
        }
        maxHorizontalCut = Math.max(maxHorizontalCut, h - prevH);
        long maxVerticalCut = 0;
        int prevV = 0;
        for (int i = 0; i < verticalCuts.length; i++) {
            maxVerticalCut = Math.max(maxVerticalCut, verticalCuts[i] - prevV);
            prevV = verticalCuts[i];
        }
        maxVerticalCut = Math.max(maxVerticalCut, w - prevV);
        long maxArea = maxHorizontalCut * maxVerticalCut;
        return (int)(maxArea % 1000000007);
    }
}