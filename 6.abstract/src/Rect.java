public class Rect implements DohyungArea, DohyungRound {
	int width;
	int height;

	public Rect(int width, int height){
		this.width =width;
		this.height = height;
	}

	@Override
	public double getRound(){
		return  (width+height)*2;
	}
	@Override
	public double getArea(){
		System.out.println("x ==="+x);
		return width*height;
	}
	
}//end class
