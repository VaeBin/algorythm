package cn.hbb.java.tree.prefix;

public class PrefixTree {

    public static class Node{
        int pass; // 经过该节点的次数
        int end; // 以该节点为结尾的次数
        Node[] nextNodes; // 可能有26条路，每一个英文a,b,c...对应一条路，如果是a则nodes里是非空，否则就是null

        public Node() {
            this.pass = 0;
            this.end = 0;
            this.nextNodes = new Node[26];
        }
    }

    public static class Tree{
        public Node root;
        public Tree(){
            root = new Node();
        }

        // insert方法
        public void insert(String word){
            if (word==null)
                return;
            Node node = root;
            node.pass++;
            char[] chars = word.toCharArray();
            for(int i = 0;i<chars.length;i++){
                //初次访问，没有节点就新填一个
                if(node.nextNodes[chars[i]-'a']==null){
                    Node next = new Node();
                    node.nextNodes[chars[i]-'a'] = next;
                }
                // 已经有该节点了,被别人走过了
                node.nextNodes[chars[i]-'a'].pass++;
                node = node.nextNodes[chars[i]-'a'];
            }
            node.end++;
        }

        // search方法,出现几次这个单词
        public int search(String word){
            if (word==null)
                return 0;

            Node node = root;
            char[] chars = word.toCharArray();
            for(int i=0;i<chars.length;i++){
                if(node.nextNodes[chars[i]-'a']==null){
                    return 0;
                }
                node = node.nextNodes[chars[i]-'a'];
            }
            return node.end;
        }



        // 以该串作为前缀的数量
        public int prefix(String word){
            if (word==null)
                return 0;

            char[] chars = word.toCharArray();
            Node node = root;
            int path = 0;
            for(int i = 0; i<chars.length;i++){
                path = chars[i]-'a';
                if(node.nextNodes[path]==null){
                    return 0;
                }
                node = node.nextNodes[path];
            }
            return node.pass;
        }

        // delete方法
        public void delete(String word){
            if(search(word)<=0)
                return;
            char[] chars = word.toCharArray();
            int path = 0;
            Node node = root;
            node.pass--;
            for(int i = 0;i<chars.length;i++){
                path = chars[i]-'a';
                if(--node.nextNodes[path].pass==0){
                    node.nextNodes[path]=null;
                }
                node = node.nextNodes[path];
            }
            node.end--;
        }









    }


}
