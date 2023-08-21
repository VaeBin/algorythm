package cn.hbb.algorithm.sorting.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 很多条线段（首尾均非负整数），求重复部分最多的线段数量
 * 暴力求解：取多个.5位置遍历每一条线段求max。
 * 小根堆求解：按照线段头从小到大排序，遍历线段，若堆顶小于等于线段头弹出（while，直到排完），线段尾加入堆。
 *
 */
public class MaximumLineRepetitionProblem {

    public static void main(String[] args) {
        int[][] lines = {{1,3},{2,4},{2,6}};
        System.out.println(maximumLineRepetitionProblem(lines));

    }

    public static class Line{
        public int begin;

        public Line(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        public int end;

    }

    /**
     * @param lines 多条线段头尾的数组
     * @return  最大重合线段数
     */
    public static int maximumLineRepetitionProblem(int[][] lines){
        // 将二维数组变为Line结构的一维数组
        Line[] line = new Line[lines.length];
        for(int i=0;i<lines.length;i++){
            line[i] = new Line(lines[i][0], lines[i][1]);
        }

        // 从小到大排序线段头
        Arrays.sort(line,new EndComparator());

        // 遍历线段，while堆里小于等于线段头的弹出，最后加入线段尾入堆。记录max
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int max = 0;
        for(int j=0;j<line.length;j++){
            while(!heap.isEmpty()&& heap.peek()<=line[j].begin){
                heap.poll();
            }
            heap.add(line[j].end);
            max = Math.max(max, heap.size());
        }
        return max;
    }

    // 比较器
    public static class EndComparator implements Comparator<Line>{
        @Override
        public int compare(Line o1, Line o2) {
            return o1.end-o2.end;
        }
    }


}
