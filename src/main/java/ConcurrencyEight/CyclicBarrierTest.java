package ConcurrencyEight;

import java.util.concurrent.CyclicBarrier;

/**
 *  @author lushiqin 20190108
 * 《java并发编程的艺术》8.2.1 CyclicBarrier(int parties)；其参数表示屏障拦截的线程数量；
 */

public class CyclicBarrierTest {
    static CyclicBarrier ba=new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ba.await();
                    System.out.println("1");

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }){}.start();

        try{
            ba.await();
            System.out.println("2");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
