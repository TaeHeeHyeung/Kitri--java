public class Guest {
	static int cnt; 
	String name; //instance 변수

	public Guest (String name){
		this.name= name;
	}
	public int visit(){
		cnt++;
		return cnt;
	}
	public void infoVisit(){
		System.out.println(name+"님은"+cnt+"번째 방문입니다.");
	}

	
}//end class
