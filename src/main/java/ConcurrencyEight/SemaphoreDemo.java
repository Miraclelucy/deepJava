package ConcurrencyEight;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *  @author lushiqin 20190108
 * 《炼数成金视频-5.JDK并发包》信号量
 *
 */
public class SemaphoreDemo implements  Runnable {
    final Semaphore semp=new Semaphore(5);//有5个信号量

    @Override
    public void run() {
        try {
            semp.acquire(2); //获取信号量
            //模拟耗时操作
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId()+":done!");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            semp.release(2);

        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SemaphoreDemo semp =new SemaphoreDemo();
        for(int i=0;i<20;i++){
            exec.submit(semp);
        }
    }
}
