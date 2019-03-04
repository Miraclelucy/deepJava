package ConcurrencyEight;

import java.util.Map;
import java.util.concurrent.*;

/**
 * * @author lushiqin 20190108
 * 《java并发编程的艺术》8.2.2 CyclicBarrier 计算用户的银行流水
 * */
public class BankCountDownLatchDemo implements  Runnable{

    private static CountDownLatch end = new CountDownLatch(4);

    //保存每个sheet的银行流水结果
    private static ConcurrentHashMap<String,Integer> sheetResult =new ConcurrentHashMap<String,Integer>();


    @Override
    public void run() {

        //执行银行流水sheet的统计计算
        try {
            Thread.sleep(2000);
            //更新sheetResult中的值
            sheetResult.put(Thread.currentThread().getName(),1);
            //使用CyclicBarrier设置屏障，等待其他线程都完成
            System.out.println("sheet"+Thread.currentThread().getId()+"准备好了！");
            end.countDown();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    public static void main(String[] args)  throws  InterruptedException{
        int result=0;
        //假设只有4个sheet
         Executor executor = Executors.newFixedThreadPool(4);
        for(int i=0;i<4;i++){
            executor.execute(new BankCountDownLatchDemo() );
        }
        //等待所有sheet准备好
        end.await();

        for (Map.Entry<String ,Integer> sheet:sheetResult.entrySet()){
            result+=sheet.getValue();
        }
        System.out.println("汇总sheet结果:"+result/4);


    }

}
