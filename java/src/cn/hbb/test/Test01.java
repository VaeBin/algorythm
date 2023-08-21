package cn.hbb.test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Test01 {
    public static Boolean valueOf(boolean b) {
        return (b ? TRUE : FALSE);
    }

    public static void main(String[] args) {
        Float a = 2.0f;
        Float b = 2.00f;
        System.out.println(a.equals(b));

        BigDecimal ba;
        BigInteger bb;

        String s = "你";
        Character c = '你';
        System.out.println("字符串常量占用的字节数为："+s.getBytes().length);


        method1("a","b");
    }

    public static void method1(String... args) {
        //......
        System.out.println(args[0]+args[1]);
    }

}
