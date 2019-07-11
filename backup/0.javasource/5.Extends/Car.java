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

	//�ٸ� �����ڿ����� this�� �ֱ⿡ super()ȣ�� �Ұ��� (this�� super�� �Ѵ� �� ���ٿ��� ����Ǿ��Ѵ�.)
	//object�� super �� ���� �� �����ȴ�.
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
		return this.maker+"���� ���� "+ color+" "+carName;
	}
}//end class