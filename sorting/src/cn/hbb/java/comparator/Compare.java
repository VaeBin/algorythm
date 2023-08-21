package cn.hbb.java.comparator;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Compare {
    public static class Student{
        public String name;
        public int id;
        public int age;
        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }
    public static class idUpAgeDownOrder implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id!=o2.id?(o1.id-o2.id):(o2.age-o1.age);
        }
    }

    public static void main(String[] args) {
        Student student = new Student("hbb", 3452, 21);
        Student student1 = new Student("hb", 3452, 23);
        Student[] stus = new Student[]{student,student1};
        Arrays.sort(stus, new idUpAgeDownOrder());
        System.out.println();

        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(student);
        arrayList.add(student1);
        arrayList.sort(new idUpAgeDownOrder());
        System.out.println();
    }



}
