package ConcurrencyEight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 *  @author lushiqin 20190108
 * 《java并发编程的艺术》8.2.2 CyclicBarrier 计算用户的银行流水
 * 每个Sheet保存一个账户近一年的每笔银行流水，现在需要统计用户的日均银行流水：
 * 先用多线程处理每个sheet里的银行流水，都执行完之后，得到每个sheet的日均银行流水，
 * 最后，再用barrierAction用这些线程的计算结果，计算出整个Excel的日均银行流水。
 */
public class BankCyclicBarrierDemo implements  Runnable{

    private CyclicBarrier c = new CyclicBarrier(4,this);
    //假设只有4个sheet
    private Executor executor = Executors.newFixedThreadPool(4);
    //保存每个sheet的银行流水结果
    private ConcurrentHashMap<String,Integer> sheetResult =new ConcurrentHashMap<String,Integer>();

    public void count(){

        for (int i=0;i<4;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {

                    //执行银行流水sheet的统计计算
                    try {
                        Thread.sleep(2000);
                        //更新sheetResult中的值
                        sheetResult.put(Thread.currentThread().getName(),1);
                        //使用CyclicBarrier设置屏障，等待其他线程都完成
                        System.out.println("sheet"+Thread.currentThread().getId()+"准备好了！");
                        c.await();

                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                }


            });
        }

    }

    /***
     * 汇总sheet,会在屏障到达后优先执行，即所有的sheet都准备好之后，会执行汇总操作
     */
    @Override
    public void run() {

        int sumresult=0;
        for (Map.Entry<String, Integer> sheet :sheetResult.entrySet()){
            sumresult+=sheet.getValue();
        }
        System.out.println("汇总平均值："+sumresult/4);

    }


    public static void main(String[] args) {
        BankCyclicBarrierDemo demo=new BankCyclicBarrierDemo();
        demo.count();
    }
}
