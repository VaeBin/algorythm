package cn.hbb.java.greed;


// 5 放灯,最少的灯
public class Lights {

    public static void main(String[] args) {

    }

    public static int lights(String s){
        char[] chars = s.toCharArray();
        // 遍历i位置，考虑放灯
        int nums = 0;
        int i = 0;
        while(i<chars.length){
            if(chars[i]=='X'){    //  X      不放灯， i=i+1
                i++;
            }
            else {
                nums++;
                // 最后一个位置了，结束了
                if(i+1 == chars.length){
                    break;
                }
                else{
                    if(chars[i+1]=='X'){   // .X     i放灯，i= i+2
                        i = i+2;
                    }
                    else{    // ..X    i放灯，i = i+3   或者   ...   i+1放灯，i = i+3
                        i = i+3;
                    }
                }
            }
        }
        return nums;
    }

}
