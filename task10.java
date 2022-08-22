
// Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения.
// Вычислить запись если это возможно

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

public class task10 {
    public static void main(String[] args) {
        String[] tokens = { "2", "+", "1", "*", "3" };
        System.out.println(Arrays.toString(tokens));
        name1(tokens);
    }

    public static void name1(String[] tokens) {
        StringBuilder ans = new StringBuilder(); // ответ
        HashMap<String, Integer> precious = new HashMap<>(); // приоритет операций
        precious.put("*", 3);
        precious.put("/", 3);
        precious.put("+", 2);
        precious.put("-", 2);
        precious.put("(", 1);

        Set<String> op = Set.of("+", "-", "/", "*", "(", ")");
        Stack<String> op2 = new Stack<>(); // куда складываем операции

        for (String index : tokens) {

            if (!op.contains(index)) {
                ans.append(index);
            } else {
                operation(index, ans, op2, precious);
            }

        }

        while (!op2.isEmpty()) {
            ans.append(op2.pop());
        }

        System.out.println(ans);
    }

    public static void operation(String index, StringBuilder ans, Stack<String> op2,
            HashMap<String, Integer> precious) {

        switch (index) {
            case "+":
                if (op2.isEmpty() || precious.get("+") > precious.get(op2.pop())) {
                    op2.add("+");
                } else {
                    ans.append(op2.pop());
                    op2.add("+");
                }
                break;

            case "-":
                if (op2.isEmpty() || precious.get("+") > precious.get(op2.pop())) {
                    op2.add("-");
                }
                break;

            case "*":
                op2.add("*");
                break;

            case "/":
                op2.add("/");
                break;

            case "(":
                while (!op2.isEmpty()) {
                    ans.append(op2.pop());
                }
                op2.add("(");
                break;

            case ")":
                while (op2.pop() != "(") {
                    ans.append(op2.pop());
                }
                break;

        }
    }
}
