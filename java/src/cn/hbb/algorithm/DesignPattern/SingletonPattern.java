package cn.hbb.algorithm.DesignPattern;

/**
 * 单例模式：饿汉模式
 * 私有构造器，静态成员指向一个实例
 * 创建类的时候已经提供好，可直接用instance，更快
 */
public class SingletonPattern {

    public static SingletonPattern instance = new SingletonPattern();
    private SingletonPattern(){}
}

/**
 * 单例模式：懒汉模式，使用getInstance返回实例，构造器私有，instance私有防止被改值，用的时候才new
 * 节省内存
 */
class SingletonPattern2 {

    private static SingletonPattern2 instance;
    private SingletonPattern2(){}

    public static SingletonPattern2 getInstance(){
        if (instance==null)
            instance = new SingletonPattern2();
        return instance;
    }
}
