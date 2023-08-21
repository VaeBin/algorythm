package cn.hbb.java.graph;

import java.util.ArrayList;

public class Node {

    public int in;
    public int out;
    public int value;
    public ArrayList<Node> nexts;   // 能到达的邻居
    public ArrayList<Edge> edges;


    public Node(int value) {
        this.in = 0;
        this.out = 0;
        this.value = value;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
