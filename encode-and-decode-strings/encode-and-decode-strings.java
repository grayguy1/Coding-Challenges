public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return Character.toString(258);
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
            sb.append(Character.toString(257));
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s.equals(Character.toString(258))) {
            return new ArrayList();
        }
        String[] arr = s.split(Character.toString(257), -1);
        return Arrays.asList(arr);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));