package thinkinginJava.springAutoProxy;
import java.lang.reflect.Method;

public class TankTimeProxy implements Movable{
    	
    public TankTimeProxy(InvocationHandler th) {
        this.th = th;
    }
    InvocationHandler th;

    @Override
    public void stop() {
        try{
             Method md=Movable.class.getMethod("stop");
            th.invoke(this,md);
        } catch(Exception e) {
         e.printStackTrace();
        }
    }

    @Override
    public void move() {
        try{
         Method md=Movable.class.getMethod("move");
            th.invoke(this,md);
         } catch(Exception e) {
            e.printStackTrace();
        }
    }
}