class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        HashMap<String, Double> weight = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            if (!graph.containsKey(eq.get(0))) {
                graph.put(eq.get(0), new ArrayList<String>());
            }
            if (!graph.containsKey(eq.get(1))) {
                graph.put(eq.get(1), new ArrayList<String>());
            }
            graph.get(eq.get(0)).add(eq.get(1));
            String key1 = eq.get(0) + " " + eq.get(1);
            weight.put(key1, values[i]);
            graph.get(eq.get(1)).add(eq.get(0));
            String key2 = eq.get(1) + " " + eq.get(0);
            weight.put(key2, 1 / values[i]);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            HashSet<String> visited = new HashSet<>();
            String start = queries.get(i).get(0);
            String target = queries.get(i).get(1);
            double res = dfs(graph, weight, start, target, 1.0, visited);
            result[i] = res;
        }
        return result;
    }
    public double dfs(HashMap<String, ArrayList<String>> graph, HashMap<String, Double> weight, String curr, String target, Double val, HashSet<String> visited) {
        if (!graph.containsKey(curr)) {
            return -1.0;
        }
        if (curr.equals(target)) {
            return val;
        }
        if (visited.contains(curr)) {
            return -1.0;
        }
        visited.add(curr);
        for (String n : graph.get(curr)) {
            String k = curr + " " + n;
            double r = dfs(graph, weight, n, target, val * weight.get(k), visited);
            if (r != -1.0) {
                return r;
            }
        }
        visited.remove(curr);
        return -1.0;
    }
}