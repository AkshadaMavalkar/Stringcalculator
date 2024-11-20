package hello;

import java.util.ArrayList;
import java.util.List;


public class stringcalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        if (numbers.startsWith("//")) {
            return handleCustomDelimiter(numbers);
        }

        return handleDefaultDelimiter(numbers);
    }

    private int handleDefaultDelimiter(String numbers) {
        String[] numberArray = numbers.split(",|\n");
        int sum = 0;
        List<String> negativeNumbers = new ArrayList<>();

        for (String numStr : numberArray) {
            if (!numStr.isEmpty()) {
                int num = Integer.parseInt(numStr);
                if (num < 0) {
                    negativeNumbers.add(String.valueOf(num));
                } else {
                    sum += num;
                }
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + String.join(", ", negativeNumbers));
        }

        return sum;
    }

    private int handleCustomDelimiter(String numbers) {
        String delimiterLine = numbers.split("\n")[0];
        String numbersPart = numbers.split("\n")[1];

        String delimiter = delimiterLine.substring(2); 


        String[] numberArray = numbersPart.split(delimiter);
        int sum = 0;
        List<String> negativeNumbers = new ArrayList<>();

        for (String numStr : numberArray) {
            if (!numStr.isEmpty()) {
                int num = Integer.parseInt(numStr);
                if (num < 0) {
                    negativeNumbers.add(String.valueOf(num));
                } else {
                    sum =sum+ num;
                }
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + String.join(", ", negativeNumbers));
        }

        return sum;
    }

    public static void main(String[] args) {
        stringcalculator calculator = new stringcalculator();

        System.out.println(calculator.add("")); 
        System.out.println(calculator.add("1")); 
        System.out.println(calculator.add("1,5")); 
        System.out.println(calculator.add("1\n2,3")); 
        System.out.println(calculator.add("//;\n1;2")); 

        try {
            System.out.println(calculator.add("//;\n1;-2"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); 
        }
    }
}

	
	   