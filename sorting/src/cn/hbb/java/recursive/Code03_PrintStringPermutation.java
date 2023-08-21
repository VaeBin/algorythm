package cn.hbb.java.recursive;

import java.util.ArrayList;
import java.util.List;

// 打印字符串的全排列
public class Code03_PrintStringPermutation {


    public static void main(String[] args) {

        String str = "abcd";
        List<String> ans = new ArrayList<>();
        permutation(str.toCharArray(), 0, ans);
        for (String a: ans){
            System.out.println(a);
        }
    }


    public static void permutation(char[] str, int index, List<String> ans){
        if(index == str.length){
            ans.add(String.valueOf(str));
        }
        else{
            for(int i = index; i < str.length; i++){
                swap(str, i, index);
                permutation(str, index+1, ans);
                swap(str, i, index);
            }
        }
    }

    public static void swap(char[] str, int i, int j){
        char temp;
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
