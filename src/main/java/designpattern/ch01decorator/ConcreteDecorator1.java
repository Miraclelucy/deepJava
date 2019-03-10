package designpattern.ch01decorator;


/**
 *  @author lushiqin 20190310
 * 《Netty源码解析-张龙》第32讲 装饰模式
 * 装饰模式的角色：
    - 抽象构件角色
    - 具体构件角色
    - 装饰角色
    - 具体装饰角色
 * ConcreteDecorator1是具体装饰角色
 *
 * */
public class ConcreteDecorator1 extends   Decorator{

    public ConcreteDecorator1(Component component){
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        doAnotherSomething();
    }

    /***
     * 增强功能
     */
    public void doAnotherSomething() {
        System.out.println("功能B");

    }


}
