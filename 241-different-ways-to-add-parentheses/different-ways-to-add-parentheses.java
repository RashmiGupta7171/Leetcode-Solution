class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return helper(expression, new HashMap<>());
    }

    private List<Integer> helper(String exp, Map<String, List<Integer>> memo) {
        if (memo.containsKey(exp)) {
            return memo.get(exp);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*') {
           
                List<Integer> left = helper(exp.substring(0, i), memo);
                List<Integer> right = helper(exp.substring(i + 1), memo);

        
                for (int l : left) {
                    for (int r : right) {
                        if (ch == '+') {
                            result.add(l + r);
                        } else if (ch == '-') {
                            result.add(l - r);
                        } else if (ch == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }

        // Base case: no operator → it's a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(exp));
        }

        memo.put(exp, result);
        return result;
    }
}