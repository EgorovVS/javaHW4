package HW4;

import java.util.Scanner;
import java.util.Stack;
//каскадная отмена с помощью cancel, выход с помощью stop
public class Task3 {

    public static void main(String[] args) {
        Stack<Double> answers = new Stack<>();
        Stack<String> equations = new Stack<>();
        while (isOn) {
            if (answers.isEmpty()) {
                if (!isOn) break;
                firstOperation(answers, equations);

            } else {
                if (!isOn) break;
                secondOperation(answers, equations);
            }
        }
    }

    public static boolean isOn = true;

    public static boolean isDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String input() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        return str;
    }

    public static void log(double a, double b, String operand, double answer, Stack<
            Double> answers, Stack<String> equations) {
        answers.add(answer);
//        equations.add(String.format("%.1f %s %.1f = ", a, operand, b));
        equations.add(a + " " + operand + " " + b + " = ");
    }

    public static void cancel(Stack stack) {
        stack.pop();
    }

    public static boolean isRightOperand(String str) {
        if (str.matches("[+-/+]")) {
            return true;
        }
        return false;

    }

    public static boolean isStop(String str) {
        if (str.equals("stop")) {
            isOn = false;
            return true;
        }
        return false;
    }

    public static void firstOperation(Stack<Double> answers, Stack<String> equations) {
        while (true) {
            System.out.print("Введите первое число: ");
            String str = input();
//            if (isStop(str)) break;

            while (!isDigit(str)) {
                if (isStop(str)) break;
                System.out.println("Вы ввели не число. Введите число ");
                str = input();
            }
            if (isStop(str)) break;
            double a = Double.parseDouble(str);
            System.out.print("Введите второе число: ");
            str = input();
//            if (isStop(str)) break;
            while (!isDigit(str)) {
                if (isStop(str)) break;
                System.out.println("Вы ввели не число. Введите второе число ");
                str = input();
            }
            if (isStop(str)) break;
            double b = Double.parseDouble(str);
            System.out.print("Введите операцию: ");
            str = input();
//            if (isStop(str)) break;
            while (!isRightOperand(str)) {
                if (isStop(str)) break;
                System.out.println("Неверный тип операции. Введите операцию");
                str = input();
            }
            if (isStop(str)) break;
            String operand = str;
            double answer = calc(a, b, operand);
            log(a, b, operand, answer, answers, equations);
            System.out.println(equations.lastElement() + answers.lastElement());
            break;
        }
    }

    public static void secondOperation(Stack<Double> answers, Stack<String> equations) {
        double a = 0;
        double b = 0;
        while (true) {
            if(answers.isEmpty()) break;
            a = answers.lastElement();
            if (a % 1 == 0) {
                System.out.println("Первое число: " + (int) a);
            } else {
                System.out.println("Первое число: " + (a));
            }
            System.out.print("Введите второе число: ");
            String str = input();
            if (str.equals("cancel")) {
                cancel(answers);
                cancel(equations);
                break;
            }
            while (!isDigit(str)) {
                if (isStop(str)) break;

                System.out.println("Вы ввели не число. Введите второе число ");
                str = input();
            }
            if (isStop(str)) break;
            b = Double.parseDouble(str);
            System.out.print("Введите операцию: ");
            str = input();
            while (!isRightOperand(str)) {
                if (isStop(str)) break;
            }
            System.out.println("Неверный тип операции. Введите операцию");
            str = input();

        if (isStop(str)) break;
        String operand = str;
        double answer = calc(a, b, operand);

        log(a, b, operand, answer, answers, equations);
        System.out.println(equations.lastElement() + answers.lastElement());
        break;
    }

}

    public static double calc(double a, double b, String operand) {
        return operand.equals("+") ? a + b : operand.equals("-") ? a - b : operand.equals("*") ? a * b : a / b;
    }

}



