package ConcurrencyFour;

import static java.lang.Thread.sleep;
/**
 * 《java并发编程的艺术》4.3.2等待通知机制 工具类 SleepUtils
 **  @author lushiqin 20181228
 */
public class SleepUtils {
    public static final void second(long millseconds) {
        try {
            sleep(millseconds);
        } catch (InterruptedException e) {
        }
    }
}

