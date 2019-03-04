package ConcurrencyEight;

import java.util.concurrent.CyclicBarrier;

/**
 *  @author lushiqin 20190108
 * 《java并发编程的艺术》8.2.1 CyclicBarrier(int parties, Runnable barrier-Action)；
 * 用于在线程到达屏障时，优先执行barrierAction，便处理更复杂的业务场景；
 */
public class CyclicBarrierTest2 {

    static CyclicBarrier ba=new CyclicBarrier(2,new A());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("1");
                    ba.await();

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }){}.start();

        try{
            System.out.println("2");
            ba.await();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static class A implements Runnable {

        @Override
        public void run() {
            System.out.println("执行A");
        }
    }
}
