    package thinkinginJava.springTransactionProxy;
  import java.lang.reflect.Method; 
    
    public class TankTimeProxy implements UserDao{
    	
    	public TankTimeProxy(InvocationHandler th) {
    		this.th = th;
    	}
        	InvocationHandler th;
    	@Override
    	public void addUser() {
        try{ 
       Method md=UserDao.class.getMethod("addUser");
    	th.invoke(this,md);
       } catch(Exception e) {
      e.printStackTrace(); }
}
    }