package cn.hbb.java.recursive;

import java.util.ArrayList;
import java.util.List;

// 打印字符串的全排列,不能重复
public class Code03_PrintStringPermutationNoRepeat {


    public static void main(String[] args) {

        String str = "abbb";
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
            boolean[] visited = new boolean[256];
            for(int i = index; i < str.length; i++){
                if(!visited[str[i]]){    // 当前index下，i位置上的值没有和index最开始的值一样才交换（i位置的值没有做过index）
                    visited[str[i]] = true;    // 设置已经交换过了
                    swap(str, i, index);
                    permutation(str, index+1, ans);
                    swap(str, i, index);
                }
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
