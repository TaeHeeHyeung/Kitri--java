public class Guest {
	static int cnt; 
	String name; //instance ����

	public Guest (String name){
		this.name= name;
	}
	public int visit(){
		cnt++;
		return cnt;
	}
	public void infoVisit(){
		System.out.println(name+"����"+cnt+"��° �湮�Դϴ�.");
	}

	
}//end class
