package ConcurrencyFour;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 《java并发编程的艺术》4.4.1等待超时机制 WaitInTimeNotify
 **  @author lushiqin 20181228
 */

public class WaitInTimeNotify {


    static boolean flag = true;
    static Object lock = new Object();
    public static void main(String[] args) throws Exception {
        Thread waitThread = new Thread(new WaitInTimeNotify.Wait(8000), "WaitThread");
        waitThread.start();
        Thread.sleep(1000);
        Thread notifyThread = new Thread(new WaitInTimeNotify.Notify(), "NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {

        long waitseconds;  //超时时间6s
        Wait(long waitseconds){
            this.waitseconds=waitseconds;
        }

        public void run() {
            long future = System.currentTimeMillis() + waitseconds; //在XX:XX:XX时间将超时
            long remaining = waitseconds;
            // 加锁，拥有lock的Monitor
            synchronized (lock) {
                //求剩余事件
                // 当条件不满足并且未超时，继续wait，同时释放了lock的锁
                if (flag&&remaining>0) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. 条件不满足，wait @ " +
                                new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait(remaining);
                        // SleepUtils.second(10000); wait后将立即释放锁，不会等到当前线程结束才释放
                    } catch (InterruptedException e) {
                    }
                    remaining=future-System.currentTimeMillis();
                    System.out.println(Thread.currentThread()+"剩余时间"+remaining +"ms");
                }

                // 当条件满足并且未超时，完成工作
                if(!flag&&remaining>0){
                    System.out.println(Thread.currentThread() + " flag is false. ，running @ " +
                            new SimpleDateFormat("HH:mm:ss").format(new Date()));
                }
                //如果超时，则推出
                else{
                    System.out.println(Thread.currentThread() + " 超时  @ " +
                            new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    return;
                }




            }
        }
    }
    static class Notify implements Runnable {
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized (lock) {
                // 获取lock的锁，然后进行通知，通知时不会释放lock的锁，
                // 直到当前线程释放了lock后，WaitThread才能从wait方法中返回
                System.out.println(Thread.currentThread() + " hold lock. notify @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5000);
            }
           // 再次加锁
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again. sleep@ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5000);
            }
        }
    }

}
