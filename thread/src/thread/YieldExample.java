package thread;

public class YieldExample {
	public static void main(String[] args) throws InterruptedException {
		YieldATest yATest= new YieldATest();
		YieldBTest yBTest= new YieldBTest();
		yATest.start();
		yBTest.start();
		Thread.sleep(3000);
		yATest.work=false;
		Thread.sleep(3000);
		yATest.work=true;
		Thread.sleep(3000);
		yATest.stop=true;
		yBTest.stop=true;
		
	}
}
