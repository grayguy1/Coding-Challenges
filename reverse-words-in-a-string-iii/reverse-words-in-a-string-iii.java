class Solution {
    public String reverseWords(String s) {
        String[] sArr = s.split(" ");
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = reverseCharacters(sArr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sArr.length - 1; i++) {
            sb.append(sArr[i]);
            sb.append(" ");
        }
        sb.append(sArr[sArr.length - 1]);
        return sb.toString();
    }
    public String reverseCharacters(String s) {
        char[] cStr = s.toCharArray();
        for (int i = 0; i < cStr.length / 2; i++) {
            char c = cStr[i];
            cStr[i] = cStr[cStr.length - 1 - i];
            cStr[cStr.length - 1 - i] = c;
        }
        return String.valueOf(cStr);
    }
}