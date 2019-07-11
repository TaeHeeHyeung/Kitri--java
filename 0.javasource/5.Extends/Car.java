public class Car {
	String carName;
	String color;
	String maker;
	int speed;

	public Car(){
		this("쏘나타", "검정색", "현대");
	}
	
	public Car(String color){
		this("쏘나타", color, "현대");
	}

	public Car(String carName, String color){
		this(carName, color, "현대");
	}

	//다른 생성자에서는 this가 있기에 super()호출 불가능 (this와 super은 둘다 맨 앞줄에서 실행되야한다.)
	//object는 super 를 실행 후 생성된다.
	public Car(String carName, String color,String maker){
		super(); 
		this.carName = carName;
		this.color = color;
		this.maker = maker;
	}


	public int speedUp(int speed){
		this.speed += speed;
		return this.speed;
	}


	public int speedDown(int speed){
		this.speed-=speed;
		if(this.speed<0)
			stop();
		return this.speed;
	}

	public void stop(){
		speed =0;
	}

	public String info(){
		return this.maker+"에서 만든 "+ color+" "+carName;
	}
}//end class