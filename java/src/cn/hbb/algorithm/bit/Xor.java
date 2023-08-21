package cn.hbb.algorithm.bit;

import java.util.HashMap;
import java.util.HashSet;

public class Xor {

    public static void main(String[] args) {
        System.out.println("不用额外变量如何交换两个数的值------------");
        int a = 6,b = 8;
        exchange(a, b);

        System.out.println("一个数组中一个数出现了奇数次，其他的数偶数次，找到那个数打印出来------------");
        int[] arr = {2,2,3,4,4,4,4,5,5,6,6,7,7};
        System.out.println(findOdd(arr));

        System.out.println("得到数的最右边的1------------");
        System.out.println(findRight1(12));

        System.out.println("一个数组中有两种数出现奇数次，其他数出现偶数次，找到出现奇数次的数------------");
        int[] arr1 = {3,5,6,6,12,12,12,12};
        int[] rst = findTwoNums(arr1);
        System.out.println("a:"+rst[0]+", b:"+rst[1]);

        System.out.println("一个数组中有一种数出现K次，其他数出现M次，M>1,K<M,找到出现K次的数，要求额外空间复杂度O(1),时间O(N)------------");
        int[] arr2 = {2,2,3,3,3,4,4,4,5,5,5,6,6,6};
        System.out.println(findKTimes(arr2, 2, 3));

        System.out.println("方法2：一个数组中有一种数出现K次，其他数出现M次，M>1,K<M,找到出现K次的数，要求额外空间复杂度O(1),时间O(N)------------");
        System.out.println(findKTimes2(arr2,2,3));

        System.out.println("比较器比较数组一个数出现K次其他数出现M次-------------------");
        int testTimes = 100;
        int range = 100;
        int num1 = (int)(Math.random()*9)+1;
        int num2 = (int)(Math.random()*9)+1;
        int K = Math.min(a,b);
        int M = Math.min(a,b);
        if (K==M)
            M++;
        int maxKinds = 10;
        int randKinds = (int)(Math.random()*maxKinds)+1;
        for (int i = 0;i<testTimes;i++){
            int[] arr3 = generateArr(randKinds, range, K, M);
            int rst1 = findKTimes(arr3, K, M);
            int rst2 = findKTimes2(arr3, K, M);
            if (rst1==rst2)
                System.out.println("yes");
            else
                System.out.println("fuck");
        }
    }

    /**
     * 不用额外变量如何交换两个数的值(两者不同的内存区域才行)
     * @param a
     * @param b
     */
    public static void exchange(int a, int b){
        System.out.println("a:"+a+", b:"+b);
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("a:"+a+", b:"+b);
    }

    /**
     * 一个数组中一个数出现了奇数次，其他的数偶数次，找到那个数打印出来
     * 全部异或就行
     * @param arr
     */
    public static int findOdd(int[] arr) {
        int rst = 0;
        for (int num: arr) {
            rst = rst^num;
        }
        return rst;
    }

    /**
     * 得到数的最右边的1
     * a&(~a+1)即a&(-a)
     * @param a
     * @return
     */
    public static int findRight1(int a){
        return a&(-a);
    }

    /**
     * 一个数组中有两种数出现奇数次，其他数出现偶数次，找到出现奇数次的数
     * @return
     */
    public static int[] findTwoNums(int[] arr){
        int[] two = new int[2];
        // 两数异或
        int xor = 0;
        for (int tem: arr) {
            xor^=tem;
        }

        // 得到最后一位1，两个数肯定一个是1，一个是0
        int rightOne = xor&(-xor);

        // 遍历得到rightOne是1的数
        int a = 0;
        for (int tem1: arr) {
            if ((tem1&rightOne)!=0)
                a^=tem1;
        }

        // 另一个数b
        int b = xor^a;

        two[0]=a;
        two[1]=b;
        return two;
    }

    /**
     * 方法1
     * 一个数组中有一种数出现K次，其他数出现M次，M>1,K<M,找到出现K次的数，要求额外空间复杂度O(1),时间O(N)
     * 把每一个数的32位二进制都累加到一个32位数组上，如果某位上%M！=0，那么出现K次那个数的该位一定为1.
     * @return
     */
    public static int findKTimes(int[] arr, int K, int M){
        int[] bits = new int[32];
        int rst = 0;
        // bits[0]代表 0位置的1出现了几个
        for (int tem: arr) {
            for (int i = 0;i<32;i++){
                // 每一个数tem的每一位是否有1，加到bits数组里去
                bits[i] += (tem>>i)&1;
            }
        }

        // 循环bits每一位取模%M
        for (int j = 0;j<32;j++){
            if (bits[j]%M!=0){
                rst = rst|(1<<j);
            }
        }

        return rst;
    }


    /**
     * 方法2
     * 一个数组中有一种数出现K次，其他数出现M次，M>1,K<M,找到出现K次的数，要求额外空间复杂度O(1),时间O(N)
     * 用hashmap
     * @return
     */
    public static int findKTimes2(int[] arr, int K, int M) {

        HashMap<Integer, Integer> map = new HashMap<>();
        // 遍历arr，得到所有的数的次数
        for (int tem:arr) {
            if (map.containsKey(tem)){
                map.put(tem, map.get(tem)+1);
            }
            else {
                map.put(tem, 1);
            }
        }
        // 遍历keyset，得到次数为K的值
        for(int key: map.keySet()){
            if (map.get(key)==K){
                return key;
            }
        }
        return -1;
    }

    /**
     * 生成一个随机的样本数组
     * @param kinds  数组里有多少种数
     * @param range  每一个数大小范围
     * @param K      有一种数出现K次
     * @param M      其他的数都出现M次
     * @return
     */
    public static int[] generateArr(int kinds, int range, int K, int M){
        int numKinds = (int)(Math.random()*kinds)+2; // 最少2种数
        int size = K*1 + M*(numKinds-1);

        // 初始化arr，长度为size
        int[] arr = new int[size];

        // 出现K次的那个数
        int kNum = randomNum(range);

        // arr中出现K次
        int index = 0;
        for(;index<K;index++){
            arr[index] = kNum;
        }

        // arr中出现numKinds-1种数，每种数都不一样，都出现M次
        numKinds--;
        while(numKinds>0){
            // 生成一种之前没有的数
            int tem;
            HashSet<Integer> set = new HashSet<>();
            do {
                tem = randomNum(range);
            }while (set.contains(tem));
            set.add(tem);

            // 添加M次该数tem
            for (int i = 0;i<M;i++)
                arr[index++] = tem;

            // numKinds数的种树-1
            numKinds--;
        }
        return arr;
    }

    /**
     * 随机生成range范围的一个数
     * @param range
     * @return
     */
    public static int randomNum(int range){
        return (int)(Math.random()*range)-(int)(Math.random()*range);
    }


}
