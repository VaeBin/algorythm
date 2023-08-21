package cn.hbb.test;

public class InterfaceTest implements Run,Eat{

    public static void main(String[] args) {
        String str = "dddfgfg";
        for(int i=0; i<str.length();i++){
            char c = str.charAt(i);
        }
    }



    @Override
    public void run() {

    }
}

interface Run{
    public abstract void run();
}

interface Eat{
    public abstract void run();
}