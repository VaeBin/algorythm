package cn.hbb.java.greed;


import java.util.Arrays;
import java.util.Comparator;

// 2 安排会议最多的场次数，以结束时间排序
public class BestArrangeConference {

    public static void main(String[] args) {

    }

    public static class Conf{
        int begin; // 会议开始时间
        int end;

        public Conf(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }

    public static int bestArrange(Conf[] confs){
        // 先按照贪心策略排序
        Arrays.sort(confs, new Comparator<Conf>() {
            @Override
            public int compare(Conf o1, Conf o2) {
                return o1.end - o2.end;
            }
        });

        // 按照结束时间遍历会议列表，迭代安排会议，比较开始时间和当前时间
        int curTime = 0;
        int confCount = 0;
        for (int i = 0; i < confs.length; i++){
            if(confs[i].begin >= curTime){
                curTime = confs[i].end;
                confCount++;
            }
        }
        return confCount;
    }
}
