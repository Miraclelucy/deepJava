package thinkinginJava.springStaticProxy;

/**
 * @描述
 * @创建人 lushiqin
 * @创建时间 2017-11-04
 * @修改人和其它信息
 */
public class CarWrapper  implements  Movable{

    Movable m;

    public CarWrapper(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        m.move();
        System.out.println("终于可以五秒破败百了。。。666666");
    }

    @Override
    public void stop() {
        m.stop();
    }
}
