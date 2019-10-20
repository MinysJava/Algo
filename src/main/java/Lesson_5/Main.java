package Lesson_5;

public class Main {
    public static void main(String[] args) {

//        System.out.println(fact(5));
        System.out.println(recSqr(2, -2));
    }

    static int fact(int n){
        int value = 1;
        for (int i = 1; i <= n ; i++) {
            value *= i;

        }
        return value;
    }

    static int recFact(int n){
        if(n <= 1){
            return 1;
        }
        return recFact(n - 1) * n;
    }

    static long fibo (int n){
        long a = 1;
        long b = 1;
        for (int i = 3; i <= n ; i++) {
            b = b + a;
            a = b - a;
        }
        return b;
    }

    static long recFibo (int n){
        if(n < 3){
            return 1;
        }
        return recFibo(n - 2) + recFibo(n - 1);
    }

    static int triangleNum(int n){
        int sum = 0;
        for (int i = 1; i <= n ; i++) {
            sum += i;
        }
        return sum;
    }

    static int recTriangleNum(int n){
        if(n <= 1){
            return 1;
        }
        return recTriangleNum(n - 1) + n;
    }

    static int multiply(int a, int b){
        int res = 0;
        for (int i = 1; i <= b ; i++) {
            res += a;
        }
        return res;
    }

//-----------------Добавил логику для работы с отрицательными числами---------------------

    static int recMultiply(int a, int b){
        int res = 0;

        if(a == 0 || b == 0){
            return 0;
        }
        if (b == 1 ) {
            return a;
        }
        if((b < 0 && a < 0) || (b > 0 && a > 0)) {
            return Math.abs(recMultiply(a, Math.abs(b) - 1) + a);
        }
        res = recMultiply(Math.abs(a), Math.abs(b) - 1) + Math.abs(a);
        return res * (-1);
    }

//--------------- Метод возведения в степень --------------

    static float recSqr(int a, int b){
        float res;

        if (b == 0){
            return 1;
        }
        if (b > 0) {
            if (b == 1) {
                return a;
            }
            return recSqr(a, b - 1) * a;
        } else {
            res = recSqr(a, Math.abs(b) - 1) * a;
            return 1 / res;
        }
    }

//----------------- Задача о рюкзаке ---------------------------
//
//    static int recBag(){
//
//    }
}
