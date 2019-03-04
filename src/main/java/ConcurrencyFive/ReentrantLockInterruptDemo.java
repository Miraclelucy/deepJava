package ConcurrencyFive;


import java.util.concurrent.locks.ReentrantLock;

/**
 *  @author lushiqin 20190107
 *  《炼数成金视频-5.JDK并发包》  ReentrantLock 可中断：可以向该线程发送一个中断信号，避免死锁和无限制的等待
 *  lockInterruptibly()
 *  当获取锁时，锁资源可用，那么当前线程成功获得锁，同时持有count设置为1，返回true.
 *  当获取锁时，锁资源可用，当前线程已持有该锁，它成功获取该锁，同时持有count增加1，返回true.
 *  当获取锁时，锁资源不可用，那么该线程开始阻塞休眠等待，但是等待过程中如果有中断事件，那么会停止等待，立即返回.
 *  当获取锁时，锁资源不可用，线程开始阻塞休眠等待，如果等待过程中锁资源变为可用，那么当前线程成功获得锁，同时持有count设置为1，返回true.

 */
public class ReentrantLockInterruptDemo implements  Runnable{
    public static ReentrantLock lock1 =new ReentrantLock();
    public static ReentrantLock lock2 =new ReentrantLock();
    int lock;//用来控制加锁的顺序，方便构造死锁
    public ReentrantLockInterruptDemo(int lock){
        this.lock=lock;
    }

    @Override
    public  void  run(){
        try {

            if(lock==1){

                lock1.lockInterruptibly();
                Thread.sleep(5000);
                lock2.lockInterruptibly();
            }
            else{
                lock2.lockInterruptibly();
                Thread.sleep(5000);
                lock1.lockInterruptibly();
            }

        }catch ( InterruptedException e){
            e.printStackTrace();
        }finally {
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            if(lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getName()+"退出");
        }

    }

    public static void main(String[] args) throws InterruptedException{
        ReentrantLockInterruptDemo r1=new ReentrantLockInterruptDemo(1);
        ReentrantLockInterruptDemo r2=new ReentrantLockInterruptDemo(2);
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(5000);
        //中断其中一个线程
        DeadlockChecker.check();
    }


}
