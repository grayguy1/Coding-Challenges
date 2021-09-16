class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String a, String b) {
                String aContent = a.substring(a.indexOf(" "));
                String bContent = b.substring(b.indexOf(" "));
                if (aContent.equals(bContent)) {
                    String aIdentifier = a.split(" ")[0];
                    String bIdentifier = b.split(" ")[0];
                    return aIdentifier.compareTo(bIdentifier);
                }
                return aContent.compareTo(bContent);
            }
        };
        ArrayList<String> lets = new ArrayList<>();
        ArrayList<String> digs = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            String s = logs[i].substring(logs[i].indexOf(" "));
            if (!Character.isDigit(s.charAt(1))) {
                lets.add(logs[i]);
            }
            else {
                digs.add(logs[i]);
            }
        }
        Collections.sort(lets, comp);
        String[] result = new String[logs.length];
        int i = 0;
        for (i = 0; i < lets.size(); i++) {
            result[i] = lets.get(i);
        }
        for (int j = 0; j < digs.size(); j++) {
            result[i] = digs.get(j);
            i++;
        }
        return result;
    }
}