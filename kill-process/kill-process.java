class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (!map.containsKey(ppid.get(i))) {
                ArrayList<Integer> children = new ArrayList<>();
                map.put(ppid.get(i), children);
            }
            map.get(ppid.get(i)).add(pid.get(i));
        }
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(kill);
        while (!q.isEmpty()) {
            int i = q.poll();
            result.add(i);
            if (!map.containsKey(i)) {
                continue;
            }
            for (int n : map.get(i)) {
                q.add(n);
            }
        }
        return result;
    }
}