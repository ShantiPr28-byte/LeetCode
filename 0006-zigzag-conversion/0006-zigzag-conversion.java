class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean goingDown = true;

        for(char ch : s.toCharArray()) {
            rows[currRow].append(ch);
            //changing direction
            if(currRow == 0) {
                goingDown = true;
            } else if(currRow == numRows - 1) {
                goingDown = false;
            }

            if(goingDown) {
                currRow++;
            } else {
                currRow--;
            }
        }

        StringBuilder result = new StringBuilder();

        for(StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}