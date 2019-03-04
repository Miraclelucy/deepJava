package thinkinginJava.springStaticProxy;

/**
 * @描述
 * @创建人 lushiqin
 * @创建时间 2017-11-04
 * @修改人和其它信息
 */
public class Car implements  Movable{

    @Override
    public void move() {
        System.out.println("加油");
    }

    @Override
    public void stop() {
        System.out.println("刹车");

    }
}
