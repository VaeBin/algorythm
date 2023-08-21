package cn.hbb.test;

import java.util.ArrayList;

public class Father<T> {

    public int age = 4;
    public T fan;
    public static void main(String[] args) {
        char[] c = {'d', 'c'};
        String ss = new String(c);
        c[0] = 'e';
        System.out.println(ss);

        Father f = new Son();
        System.out.println(f.age);
        ArrayList<String> arrayList;
    }


}

class Son extends Father<Integer>{

    public int age = 11;
}