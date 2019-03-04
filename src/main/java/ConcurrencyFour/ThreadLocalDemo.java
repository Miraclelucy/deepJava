package ConcurrencyFour;
/**
 * 《java并发编程的艺术》4.3.6 ThreadLocalDemo
 **  @author lushiqin 20181228
 */

public class ThreadLocalDemo {

    // 第一次get()方法调用时会进行初始化（如果set方法没有调用），每个线程会调用一次
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };
    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    /**
     * 返回从begin()方法调用开始到end()方法被调用时的时间差，单位是毫秒
     * @return
     */
    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }
    public static void main(String[] args) throws Exception {
        ThreadLocalDemo.begin();
        SleepUtils.second(1000);
        System.out.println("Cost: " + ThreadLocalDemo.end() + " mills");
    }
}
