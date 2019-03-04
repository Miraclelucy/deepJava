package ConcurrencyFive;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  @author lushiqin 20190107
 * 炼数成金视频-5.JDK并发包 ReentrantLock与Condition
 *
 */
public class ReentrantLockCondition  implements  Runnable {
    public  static ReentrantLock rtlock=new ReentrantLock();
    public static Condition condition =rtlock.newCondition();

    @Override
    public void run() {
        try {
            rtlock.lock();
            condition.await();
            System.out.println("thread is going");
        }catch (Exception e){

        }finally {
            rtlock.unlock();
        }
    }

    public static void main(String[] args) throws  InterruptedException {
        ReentrantLockCondition rlc=new ReentrantLockCondition();
        Thread t1=new Thread(rlc);
        t1.start();
        Thread.sleep(2000);
        //通知线程继续执行
        rtlock.lock();
        condition.signal(); //用户唤醒一个在等待中的线程 类似于notify()
        rtlock.unlock();

    }
}
