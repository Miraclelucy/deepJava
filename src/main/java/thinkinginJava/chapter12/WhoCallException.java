package thinkinginJava.chapter12;

public class WhoCallException {
	public  void  f(){
		try{
			throw new Exception();
		}
		catch(Exception  e ){
			e.printStackTrace();
			for(StackTraceElement item :e.getStackTrace()){
				System.out.println(item.getMethodName());
			}
		}
		
	}
	
	public void g(){ f();}
	public void h(){ g();}
	
	public static void main(String[] args) {
		WhoCallException w=new WhoCallException();
		//w.f();
		//System.out.println("---------------------");
		//w.g();
		System.out.println("---------------------");
		w.h();
	}
}
