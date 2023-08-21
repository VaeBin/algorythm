package cn.hbb.algorithm.greed;


import java.util.Arrays;
import java.util.Comparator;

// 1 最小字典序拼接字符串数组
public class LowestLexicography {

    public static void main(String[] args) {
        String[] strs = {"b","ba"};
        System.out.println(lowestString2(strs));
    }

    // 贪心,利用比较器排序拼接顺序

    public static String lowestString2(String[] strs){
        if (strs==null || strs.length==0){
            return "";
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo((o2+o1));
            }
        });
        StringBuilder res = new StringBuilder();
        for(int i=0; i<strs.length; i++){
            res.append(strs[i]);
        }
        return res.toString();
    }


}
