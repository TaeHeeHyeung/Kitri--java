public class ForTest2 {
	public static void main(String[] args) {
		System.out.println("������1");
		for(int y=1; y<10; y++){	
			for(int x=2; x<10; x++){	
				System.out.print(x+"*"+y+"="+ x*y+" ");
			}
				System.out.println();
		}
		System.out.println("������2");
		for(int x=2; x<10; x++){	
			for(int y=1; y<10; y++){	
				System.out.print(x+"*"+y+"="+ x*y+" ");
			}
				System.out.println();
		}
	}//end main
}
