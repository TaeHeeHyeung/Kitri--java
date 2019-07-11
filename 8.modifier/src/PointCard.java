public class PointCard {
	static int cnt;
	String name;

	public PointCard (String name){
		this.name= name;
	}
	public int visit(){
		cnt++;
		return cnt;
	}

	public void infoPoint(){
		System.out.println(name+"님의 포인트는"+cnt+"입니다.");
	}
	
}//end class
