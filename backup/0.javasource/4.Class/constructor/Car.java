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

	public Car(String carName, String color,String maker){
		this.carName = carName;
		this.color = color;
		this.maker = maker;
	}

	public void speedUp(){
		speed+=10;
	}

	public int speedUp(int speed){
		this.speed += speed;
		return this.speed;
	}

	public void speedDown(){
		speed+=10;
		if(speed<0)
			stop();
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
		return "차이름 : " +this.carName +" 색상 : " + this.color + " 제조사 : "+ this.maker+"속도"+this.speed;
	}
}//end class