import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Description:
 * Created by wangzhonghai01 on 2019/11/2.
 */
public class Main {
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {

        Thread thread1 = new Thread(new B());

        Thread thread2 = new Thread(new C());

        thread1.start();
        thread2.start();

//        for (int i = 0; i < 10; ) {
//            oneLine();
//
//            System.out.println();
//            System.out.println();
//            System.out.println("=================================================================================================");
//            System.out.println();
//            i ++;
//        }
    }

    private static void oneLine() {
        for (int i = 0; i < 3;) {
            int r = oneItem();
            if (r < 4) continue;

            i++;
        }
    }

    private static int oneItem() {
        int first = new Random().nextInt(10);
        int second  = new Random().nextInt(10);
        if (first < 2 || second < 2) return 0;
        if (set.contains(first * second)) return 0;
        set.add(first * second);
        System.out.print(first + " * " + second + " = ______");
        System.out.print("\t\t\t");
        return first * second;
    }
}


class A {
    public static String a = "a";
    public static String b = "b";
    public static void a() {
        System.out.println("a");
    }
    public static void b() {
        System.out.println("b");
    }
}


class B implements Runnable {

    @Override
    public void run() {
        synchronized (A.class) {
            System.out.println("B1");
            A.a();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B2");
            A.b();
            System.out.println("B3");
        }
    }
}


class C implements Runnable {

    @Override
    public void run() {
        synchronized (A.class) {
            System.out.println("C1");
            A.b();
            System.out.println("C2");
            A.a();
            System.out.println("C3");
        }
    }
}
