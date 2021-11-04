class FileSystem {
    class Trie{
        HashMap<String, Trie> folder = new HashMap<>();
        Integer s;
    }

    Trie root;
    public FileSystem() {
        root = new Trie();
    }
    
    public boolean createPath(String path, int value) {
        String[] p = path.split("/");
        Trie curr = root;
        for (int i = 1; i < p.length; i++) {
            if (!curr.folder.containsKey(p[i])) {
                if (i == p.length - 1) {
                    Trie t = new Trie();
                    curr.folder.put(p[i], t);
                }
                else {
                    return false;
                }
            }
            curr = curr.folder.get(p[i]);
        }
        if (curr.s != null) {
            return false;
        }
        curr.s = value;
        return true;
    }
    
    public int get(String path) {
        String[] p = path.split("/");
        Trie curr = root;
        for (int i = 1; i < p.length; i++) {
            if (!curr.folder.containsKey(p[i])) {
                return -1;
            }
            curr = curr.folder.get(p[i]);
        }
        if (curr.s != null) {
            return curr.s;
        }
        return -1;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */