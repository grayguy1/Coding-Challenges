class FileSystem {
    class Node {
        HashMap<String, Node> folders = new HashMap<>();
        HashMap<String, String> files = new HashMap<>();
    }
    Node base;
    public FileSystem() {
        base = new Node();
    }
    
    public List<String> ls(String path) {
        String[] pathArr = path.split("/");
        Node temp = base;
        for (int i = 1; i < pathArr.length - 1; i++) {
            if (temp == null) {
                return new ArrayList<>();
            }
            temp = temp.folders.get(pathArr[i]);
        }
        if (pathArr.length != 0) {
            String last = pathArr[pathArr.length - 1];
            if (temp.files.containsKey(last)) {
                ArrayList<String> result = new ArrayList<>();
                result.add(last);
                return result;
            }
            else if (temp.folders.containsKey(last)) {
                temp = temp.folders.get(last);
            }
        }
        ArrayList<String> result = new ArrayList<>(temp.files.keySet());
        for (String f : temp.folders.keySet()) {
            if (f != null) {
                result.add(f);
            }
        }
        Collections.sort(result);
        return result;
    }
    
    public void mkdir(String path) {
        String[] pathArr = path.split("/");
        Node temp = base;
        for (int i = 1; i < pathArr.length; i++) {
            if (!temp.folders.containsKey(pathArr[i])) {
                Node curr = new Node();
                temp.folders.put(pathArr[i], curr);
            }
            temp = temp.folders.get(pathArr[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] pathArr = filePath.split("/");
        Node temp = base;
        for (int i = 1; i < pathArr.length - 1; i++) {
            if (!temp.folders.containsKey(pathArr[i])) {
                Node curr = new Node();
                temp.folders.put(pathArr[i], curr);
            }
            temp = temp.folders.get(pathArr[i]);
        }
        String last = pathArr[pathArr.length - 1];
        temp.files.put(last, temp.files.getOrDefault(last, "") + content);
    }
    
    public String readContentFromFile(String filePath) {
        String[] pathArr = filePath.split("/");
        Node temp = base;
        for (int i = 1; i < pathArr.length - 1; i++) {
            if (temp.folders.containsKey(pathArr[i])) {
                temp = temp.folders.get(pathArr[i]);
            }
            else {
                return "";
            }
        }
        String last = pathArr[pathArr.length - 1];
        return temp.files.get(last);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */