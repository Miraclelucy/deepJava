package designpattern.ch01decorator;


/**
 *  @author lushiqin 20190310
 * 《Netty源码解析-张龙》第32讲 装饰模式
 * 装饰模式的角色：
        - 抽象构件角色
        - 具体构件角色
        - 装饰角色
        - 具体装饰角色
 * Component本身是抽象构件角色
 *
 * */
public interface Component {

    void doSomething();
}
