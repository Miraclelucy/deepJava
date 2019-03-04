package ConcurrencyFive;


import java.util.concurrent.locks.ReentrantLock;

/**
 *  @author lushiqin 20190107
 *  《炼数成金视频-5.JDK并发包》 可重入锁
 *
 */
public class ReentrantLockDemo implements Runnable{
    public  static ReentrantLock rtlock=new ReentrantLock();
    public static  int i=0;

    @Override
    public  void run(){

     for ( int j=0;j<100000;j++){

         rtlock.lock();
        try{
            i++;
        }finally {

            rtlock.unlock();
         }

        }

    }

    public static void main(String[] args)  throws InterruptedException {

        ReentrantLockDemo em=new ReentrantLockDemo();
        Thread t1=new Thread(em);
        Thread t2=new Thread(em);
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println(i);
    }





}
