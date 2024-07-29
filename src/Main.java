//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.List;

public class Main {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n"; // default delimiters
        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterEnd);
            numbers = numbers.substring(delimiterEnd + 1);
        }

        String[] numberArray = numbers.split(delimiter);
        List<Integer> negativeNumbers = new ArrayList<>();
        int sum = 0;

        for (String number : numberArray) {
            if (!number.isEmpty()) {
                int num = Integer.parseInt(number);
                if (num < 0) {
                    negativeNumbers.add(num);
                } else {
                    sum += num;
                }
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbers);
        }

        return sum;
    }

    public static void main(String[] args) {
        Main calculator = new Main();

        System.out.println(calculator.add("")); // Output: 0
        System.out.println(calculator.add("1")); // Output: 1
        System.out.println(calculator.add("1,5")); // Output: 6
        System.out.println(calculator.add("1\n2,3")); // Output: 6
        System.out.println(calculator.add("//;\n1;2")); // Output: 3

        try {
            System.out.println(calculator.add("1,-2,3,-4")); // Should throw an exception
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Output: Negative numbers not allowed: [-2, -4]
        }
    }
}

