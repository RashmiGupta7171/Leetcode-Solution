import java.util.*;

class Solution {

    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        // Create graph
        Map<String, List<Pair>> graph = new HashMap<>();

        // Build graph
        for (int i = 0; i < equations.size(); i++) {

            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            double value = values[i];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            // a / b = value
            graph.get(a).add(new Pair(b, value));

            // b / a = 1 / value
            graph.get(b).add(new Pair(a, 1.0 / value));
        }

        double[] result = new double[queries.size()];

        // Process queries
        for (int i = 0; i < queries.size(); i++) {

            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) ||
                !graph.containsKey(end)) {

                result[i] = -1.0;

            } else {

                Set<String> visited = new HashSet<>();

                result[i] = dfs(
                        start,
                        end,
                        graph,
                        visited
                );
            }
        }

        return result;
    }

    private double dfs(
            String current,
            String target,
            Map<String, List<Pair>> graph,
            Set<String> visited) {

        // If current variable is target
        if (current.equals(target)) {
            return 1.0;
        }

        visited.add(current);

        for (Pair edge : graph.get(current)) {

            String next = edge.variable;
            double weight = edge.value;

            if (visited.contains(next)) {
                continue;
            }

            double result = dfs(
                    next,
                    target,
                    graph,
                    visited
            );

            if (result != -1.0) {
                return weight * result;
            }
        }

        return -1.0;
    }

    // Pair class
    class Pair {
        String variable;
        double value;

        Pair(String variable, double value) {
            this.variable = variable;
            this.value = value;
        }
    }
}