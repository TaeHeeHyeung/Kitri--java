public class Car {
	String carName;
	String color;
	String maker;
	int speed;

	public Car(){
		this("�Ÿ", "������", "����");
	}
	
	public Car(String color){
		this("�Ÿ", color, "����");
	}

	public Car(String carName, String color){
		this(carName, color, "����");
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
		return "���̸� : " +this.carName +" ���� : " + this.color + " ������ : "+ this.maker+"�ӵ�"+this.speed;
	}
}//end class