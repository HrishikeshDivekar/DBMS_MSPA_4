/* 
    THIS IS SAMPLE PROBLEM FOR BEGINNERS IF YOU ARE NEW TO JAVA 
    Now tell what will this Class File return?
*/

public class Problem1 {
    public static int fn1(int i){
        i = fn4(i);
        return i+1;
    }
    public static int fn2(int i){
        i = fn1(i);
        return i+1;
    }
    public static int fn3(int i){
        i = fn2(i);
        return i+1;
    }
    public static int fn4(int i){
        i = fn3(i);
        return i+1;
    }

    public static void main(String[] args) {
        System.out.println(fn1(1));
        System.out.println(fn2(1));
        System.out.println(fn3(1));
        System.out.println(fn4(1));
    }
}
