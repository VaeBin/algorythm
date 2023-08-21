package cn.hbb.java.graph;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//深度优先遍历，迭代，入栈即打印
public class Code02_DFS {

    public static void dfs(Node start){
        if(start==null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        HashSet<Node> set  = new HashSet<>();
        //第一个节点进队列，set，同时打印压栈即打印
        stack.add(start);
        set.add(start);
        System.out.println(start.value);
        //while判断栈空否，弹出看nexts
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            //next非set里，打印并将pop和next入队压栈，break
            for(Node next: pop.nexts){
                if (!set.contains(next)){
                    System.out.println(next.value);
                    set.add(next);
                    stack.push(pop);
                    stack.push(next);

                    break;   // 发现一个非空就退出
                }
            }
        }
    }
}
