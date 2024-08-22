package com.himedia.practice;

public class B_variable_function {
    public static int add(int a, int b) {
        int sum = a + b;
        return sum;
    }
    public static int minus(int a, int b) {
        int minus = a - b;
        return minus;
    }
    public static int multiply(int a, int b) {
        int multiply = a * b;
        return multiply;
    }
    public static double divide(int a, int b) {
        int divide = a / b;
        return divide;
    }
    public static void main(String[] args) {
        int a = 10;
        int b =3;
        int result = add(a,b);
        System.out.println(result);
        int result1 = minus(a,b);
        System.out.println(result1);
        int result2 = multiply(a,b);
        System.out.println(result2);
        double dResult = divide(a,b);
        System.out.println(dResult);
    }
}
