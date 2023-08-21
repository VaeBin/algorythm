package cn.hbb.java.tree;

import java.util.List;

// 15 公司最大快乐值。递归套路
public class MaxHappy {
    public static void main(String[] args) {


    }

    public static class Employee{
        int happy;
        List<Employee> nexts;

        public Employee(int happy) {
            this.happy = happy;
        }
    }

    public static class Info{
        int no; // 头不来时最大happy值
        int yes;

        public Info(int no, int yes) {
            this.no = no;
            this.yes = yes;
        }
    }

    public static int maxHappy(Employee head){
        Info allInfo = process(head);
        return Math.max(allInfo.yes, allInfo.no);

    }
    public static Info process(Employee x){
        if (x==null){
            return new Info(0,0);
        }

        int no = 0;
        int yes = x.happy;

        for (Employee next: x.nexts){
            Info nextInfo = process(next);
            yes += nextInfo.no;
            no += Math.max(nextInfo.yes, nextInfo.no);
        }

    return new Info(no, yes);
    }
}
