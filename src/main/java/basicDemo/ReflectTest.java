package basicDemo;

import java.lang.reflect.Method;

//对接收数组参数的成员方法进行调用？
//举例：
public class ReflectTest {
    public static void main(String[] args) throws Exception {
		String str="basicDemo.ArgumentTest";
		Method m=Class.forName(str).getMethod("main",String[].class); //获取到某个指定类的main方法
		m.invoke(null, (Object)new String[]{"123","456"});
				
	}
}
