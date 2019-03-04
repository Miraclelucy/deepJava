package ConcurrencyFive;


import java.util.concurrent.locks.ReentrantLock;

/**
 *  @author lushiqin 20190107
 *  《炼数成金视频-5.JDK并发包》 ReentrantLock可重入：lock了几次就必须释放几次。
 *  当锁可用，并且当前线程没有持有该锁，直接获取锁并把count set为1.
 *  当锁可用，并且当前线程已经持有该锁，直接获取锁并把count增加1.
 *  当锁不可用，那么当前线程被阻塞，休眠一直到该锁可以获取，然后把持有count设置为1.
 *  这种方式获取锁不可中断，如果获取不到则一直休眠等待。
 */
public class ReentrantLockDemo2 implements Runnable{
    public  static ReentrantLock rtlock=new ReentrantLock();
    public static  int i=0;

    @Override
    public  void run(){

     for ( int j=0;j<100000;j++){

         rtlock.lock();
         rtlock.lock();
        try{
            i++;
        }finally {

            rtlock.unlock();
            rtlock.unlock();//如果只释放一次 ，会导致死锁，其他线程将无法进入。
         }

        }

    }

    public static void main(String[] args)  throws InterruptedException {

        ReentrantLockDemo2 em=new ReentrantLockDemo2();
        Thread t1=new Thread(em);
        Thread t2=new Thread(em);
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println(i);
    }





}
