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
		System.out.println(name+"���� ����Ʈ��"+cnt+"�Դϴ�.");
	}
	
}//end class
