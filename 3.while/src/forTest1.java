public class  forTest1{
	public static void main(String[] args) {
		System.out.println("1~10 까지 출력");
		for(int i=1;i <11; i++){
			System.out.print(i+" \t");
		}

		System.out.println("1~10까지 (홀수만)");
		for(int i=1;i <11; i++){
			if(i%2==1){
				System.out.print(i+" ");	
			}
		}
		//증감연산자를 활용한 반복문 횟수 줄이기
		for(int i=1;i <11; i+=2){
			System.out.print(i+" ");	
		}

		//i를 개행처리보다 먼저 출력하는것과 뒤에 출력하는것은 차이가 있다.
		System.out.println();
		System.out.println("1~100까지 (10개 단위 줄 바꿈)");
		for(int i=1;i <=100; i++){
			System.out.print(i+" ");	
			if(i%10==0 ){
				System.out.println(" ");	
			}
		}


		System.out.println("프로그램 종료");
	}//end main
}
