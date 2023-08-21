package cn.hbb.algorithm.bit;

public class Code01 {

    public static void main(String[] args) {

        int num = 3;
        printDecimal2Binary(num);

        System.out.println("-----------------------------");

        int num1 = Integer.MIN_VALUE;
        printDecimal2Binary(num1);
        // 带符号右移
        printDecimal2Binary((num1>>1));
        // 不带符号右移
        printDecimal2Binary((num1>>>1));

        System.out.println("---------------");

        // 相反数除了用-，还可以取反+1，MIN_VALUE相反数还是自身
        printDecimal2Binary(num1);
        printDecimal2Binary(~num1+1);

    }

    /**
     * 输出一个数的32位2进制表示
     * @param num
     */
    public static void printDecimal2Binary(int num){

        for (int i = 31;i>=0;i--){
            System.out.print((num&(1<<i))==0?"0":"1");
        }
        System.out.println();
    }
}
