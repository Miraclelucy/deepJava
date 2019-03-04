package ConcurrencyThree;


/**
 * 《netty权威指南》21.2.3 volatile的正确使用
 *
 * @author lushiqin 20190215
 */
public class VolatileDemo {
    private  static boolean stop;

    public static void main(String[] args)  throws  Exception{

        Thread  t=new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(!stop){
                    i++;
                    try {
                        Thread.sleep(1000);
                        System.out.println(i);
                    }
                    catch ( Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });

        t.start();
        Thread.sleep(3000);
        stop=true;

    }

}
