package cn.hbb.algorithm.string;

import java.util.regex.Pattern;

public class HuiWenStr {

    public static void main(String[] args) {

        String str1 = "http://www.baidu.com";
        System.out.println(Pattern.matches("^http://\\w{3,}\\.\\w*\\.?com$",str1)) ;
        System.out.println(judge("abaa"));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    public static boolean judge (String str) {
        // write code here

        int len = str.length();
        if(len==1)
            return true;

        int left = 0;
        int right = len-1-left;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right))
                return false;
        }
        try {
            String str1 = "http://www.baidu.com";
            Pattern.matches("^http://\\w{3,}\\.\\w*\\.?com$",str1) ;
        }catch (Exception e){

        }
        finally {

        }

        return true;
    }
}