package ConcurrencyEight;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  @author lushiqin 20190108
 *  《炼数成金视频-5.JDK并发包》 CountDownLatchDemo 倒数计时器 每个线程都完成，才能算是执行通过。
 */

public class CountDownLatchDemo  implements  Runnable{
      static final CountDownLatch  end =new CountDownLatch(10);

    @Override
    public void run() {
        try{
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId()+" complete!");
            end.countDown();//用来通知主线程，子线程完成了任务

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        finally{

        }

    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo  demo =new CountDownLatchDemo();
        ExecutorService exec= Executors.newFixedThreadPool(10);
        for (int i=0;i<10;i++){
            exec.submit(demo);
        }
        // 等待所有子线程完成任务
        end.await();
        System.out.println("Fire !");
        exec.shutdown();

    }
}
