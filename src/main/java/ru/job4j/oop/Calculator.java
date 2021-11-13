package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return x - y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int a) {
        return x / a;
    }

    public int sumAllOperation(int a) {
        return sum(a) + minus(a) + multiply(a) + divide(a);
    }

    public static void main(String[] args) {
        int rslSum = Calculator.sum(10);
        int rslMinus = Calculator.minus(10);
        System.out.println(rslSum);
        System.out.println(rslMinus);
        Calculator calculator = new Calculator();
        int rslMultiply = calculator.multiply(5);
        int rslDivide = calculator.divide(5);
        int rslSumAllOperation = calculator.sumAllOperation(5);
        System.out.println(rslMultiply);
        System.out.println(rslDivide);
        System.out.println(rslSumAllOperation);
    }
}