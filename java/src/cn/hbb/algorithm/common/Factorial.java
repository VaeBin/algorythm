package cn.hbb.algorithm.common;

public class Factorial {

    public static void main(String[] args) {

        int n = 3;
        System.out.println(factorial(n));


    }


    /**
     * 1!+2!+3!+...+n!=?
     *
     *存储上次结果
     */
    public static long factorial(int n){

        long rst = 0;
        long last = 1;
        for (int i = 1;i<=n;i++){
            rst += last*i;
        }
        return rst;

    }

}
