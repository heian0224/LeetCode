import java.util.Map;

public class Problem13 {
    /**
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * @param roman roman string
     * @return number
     */
    public int romanToInt(String roman) {
        Map<Character, Integer> romanMap = Map.of('M', 1000,
                'D', 500,
                'C', 100,
                'L', 50,
                'X', 10,
                'V', 5,
                'I', 1);
        int index = 0;
        int result = 0;
        while (index < roman.length()) {
            boolean isLast = index == roman.length() - 1;
            char currentChar = roman.charAt(index);
            int currentNum = romanMap.get(currentChar);
            if (!isLast) {
                char nextChar = roman.charAt(index + 1);
                int nextNum = romanMap.get(nextChar);

                if (nextNum > currentNum) {
                    result -= currentNum;
                } else {
                    result += currentNum;
                }
            } else {
                result += currentNum;
            }
            index++;
        }


        return result;
    }


}
