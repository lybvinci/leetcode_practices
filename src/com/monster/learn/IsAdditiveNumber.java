package com.monster.learn;

// 50.00%
public class IsAdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= num.length() >> 1; i++)
            for (int j = 1; j + i < num.length(); j++) // ①
                if (isValid(num, num.substring(0, i), num.substring(i, i + j), i + j))
                    return true;
        return false;
    }

    private boolean isValid(String num, String first, String second, int index) {
        if (first.length() > 1 && first.startsWith("0") || second.length() > 1 && second.startsWith("0"))
            return false;
        if (index == num.length())
            return true;
        long sum = Long.parseLong(first) + Long.parseLong(second);
        if (num.startsWith(sum + "", index))
            if (isValid(num, second, sum + "", index + (sum + "").length()))
                return true;
        return false;
    }
}