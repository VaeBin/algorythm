package cn.hbb.java.recursive;


import java.util.ArrayList;
import java.util.List;

// 打印字符串的所有子序列
public class Code01_PrintAllSubSequences {

    public static void main(String[] args) {

        ArrayList<String> ans = new ArrayList<>();
        String str = "abc";
        String path = "";
        process1(str.toCharArray(),0,ans,path);

        for (String sub: ans){
            System.out.println(sub);
        }
    }

    //递归：固定字符串，index位置下的ans字符串list等于，
    // [0, index-1]的子序列path选择基础上选择当前index处的字符的递归和不选择的递归，终止条件为iindex超标。
    /**
     *
     * @param str 固定原字符串
     * @param index  走到了index位置
     * @param ans    走到index位置之前已经包含了的字符串子序列集合
     * @param path   之前的路径选择
     */
    public static void process1(char[] str, int index, List<String> ans, String path){
        if(index==str.length){
            ans.add(path);
            return;
        }

        // 不要index的字符
        process1(str, index+1, ans, path);

        // 要index的字符
        process1(str, index+1, ans, path+str[index]);
    }

}
