class Solution {
    public String convertToTitle(int columnNumber) {
        String str = "";
        while ( columnNumber > 0){
            columnNumber--;
            str = (char)(columnNumber % 26 + 'A') + str;
            columnNumber = columnNumber / 26;
        }
        return str;
    }
}