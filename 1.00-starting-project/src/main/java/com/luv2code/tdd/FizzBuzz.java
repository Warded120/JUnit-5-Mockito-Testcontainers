package com.luv2code.tdd;

public class FizzBuzz {
    public static String compute(int n) {
        StringBuilder result = new StringBuilder();

        if(n % 3 == 0) {
            result.append("Fizz");
        }

        if(n % 5 == 0) {
            result.append("Buzz");
        }

        if(result.isEmpty()) {
            result.append(n);
        }

        return result.toString();
    }
}
