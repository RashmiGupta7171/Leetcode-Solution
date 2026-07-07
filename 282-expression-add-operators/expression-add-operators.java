class Solution {

    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();

        if (num == null || num.length() == 0)
            return ans;

        backtrack(ans, "", num, target, 0, 0, 0);
        return ans;
    }

    private void backtrack(List<String> ans, String path, String num,
                           int target, int index,
                           long calcValue, long prevNum) {

     
        if (index == num.length()) {
            if (calcValue == target) {
                ans.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {

            if (i != index && num.charAt(index) == '0')
                break;

            String currStr = num.substring(index, i + 1);
            long currNum = Long.parseLong(currStr);

            if (index == 0) {
                backtrack(ans, currStr, num, target,
                        i + 1, currNum, currNum);
            } else {

                backtrack(ans,
                        path + "+" + currStr,
                        num,
                        target,
                        i + 1,
                        calcValue + currNum,
                        currNum);

                backtrack(ans,
                        path + "-" + currStr,
                        num,
                        target,
                        i + 1,
                        calcValue - currNum,
                        -currNum);

                backtrack(ans,
                        path + "*" + currStr,
                        num,
                        target,
                        i + 1,
                        calcValue - prevNum + (prevNum * currNum),
                        prevNum * currNum);
            }
        }
    }
}