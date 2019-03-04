package ConcurrencyFive;


import java.util.concurrent.locks.LockSupport;

/**
 *  @author lushiqin 20190107
 * 《炼数成金视频-5.JDK并发包》LockSupport:阻塞或者唤醒一个线程
 *  在jdk的底层使用较多。功能类似于suspend,后者已过时
 */

public class LockSupportDemo {
    public static Object u=new Object();
    static ChangeNameThread t1= new ChangeNameThread("t1");
    static ChangeNameThread t2= new ChangeNameThread("t2");


    private static class ChangeNameThread extends   Thread {
        public  ChangeNameThread (String name){
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u){
                System.out.println("当前线程是："+Thread.currentThread().getName());
                LockSupport.park();
            }
        }
    }

    public static void main(String[] args)  throws  InterruptedException{
        t1.start();
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        //t1.join();
        //t2.join();



    }
}
