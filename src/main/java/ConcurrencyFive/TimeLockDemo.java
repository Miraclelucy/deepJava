package ConcurrencyFive;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  @author lushiqin 20190107
 * 《炼数成金视频-5.JDK并发包》 ReentrantLock 可限时：设置超时时间，避免无限制的等待
 *  tryLock(long timeout, TimeUnit unit)
 *  当获取锁时，锁资源在超时时间之内变为可用，并且在等待时没有被中断，
 *      那么当前线程成功获取锁，返回true，同时当前线程持有锁的count设置为1
 *  当获取锁时，在超时时间之内没有锁资源可用，那么当前线程获取失败，不再继续等待，返回false.
 *  当获取锁时，在超时等待时间之内，被中断了，那么抛出InterruptedException，不再继续等待.
 *  当获取锁时，在超时时间之内锁可用，并且当前线程之前已持有该锁，那么成功获取锁，同时持有count加1.

 */
public class TimeLockDemo implements Runnable {
    public static ReentrantLock  lock=new ReentrantLock();
    @Override
    public void run(){

        try {
            if(lock.tryLock(5, TimeUnit.SECONDS)){ //tryLock
                System.out.println(Thread.currentThread().getName()+" get the lock");
                Thread.sleep(6000);
            }else{
                System.out.println(Thread.currentThread().getName()+" fail,i am so sorry");

            }

        }catch (Exception e){


        }

        finally {
            if(lock.isHeldByCurrentThread())
            {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TimeLockDemo r1=new TimeLockDemo();
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r1);
        t1.start();
        t2.start();


    }
}


