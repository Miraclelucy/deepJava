package thinkinginJava.springStaticProxy;

/**
 * @描述 装饰者模式（静态代理） 对需要加强的方法加强，不需要加强的方法保持不变
 * @创建人 lushiqin
 * @创建时间 2017-11-04
 * @修改人和其它信息
 */
public class TestWrapper {
    public static void main(String[] args) {
        Car c=new Car();
        CarWrapper t=new CarWrapper(c);
        t.move();
        t.stop();
    }
}
