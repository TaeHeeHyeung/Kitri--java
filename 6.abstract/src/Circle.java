
public class Circle implements DohyungArea, DohyungRound {
	int r;
	double PI= Math.PI;

	Circle(int r){
		this.r=r;
	}

	@Override
	public double getRound(){
		return (2*PI*r);
	}

	@Override
	public double getArea(){
		return (PI*Math.pow(r,2));
	}
	
}//end class
