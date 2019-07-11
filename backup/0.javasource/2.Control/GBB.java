/**
 가위 바위 보 게임.
 1. 0 (가위)  1 (바위) 2 (보)
 2. 컴퓨터 : 난수 (0, 1, 2)
 3. 결과 logic 이김, 짐, 비김
 4. 결과 출력
 나: 보 2, 컴: 바위 1	    결과: 이겼다.
 나: 보 2, 컴: 보	   2		결과: 비겼다.
 나: 보 2, 컴: 가위 0		결과: 졌다.
 
 결과 3가지가 33.3...%로 동일하다.
 이럴 경우 규칙이 존재한다.
*/


public class GBB {
	public static void main(String[] args) {
		int my = 1;
		//(int) (Math.random()*3)
		int com = 2;
		if(my == com){
			System.out.println("com: "+com+ " my: "+my+" 비겼다.");
		}else if(my == 0 && com == 2){
			System.out.println("com: "+com+ " my: "+my+" 이겼다.");
		}else if(my == 2 && com == 0){
			System.out.println("com: "+com+ " my: "+my+" 졌다.");
		}else if( my > com ){
			System.out.println("com: "+com+ " my: "+my+" 이겼다.");
		}else {
			System.out.println("com: "+com+ " my: "+my+" 졌다.");
		}
// 위 문제를 축약시키기
		if(my == com){
			System.out.println("com: "+com+ " my: "+ my +" 비겼다.");
		}else if(my > com  &&  (my != 2 || com !=0) || (my == 0 && com ==2) ) {
 			System.out.println("com: "+com+ " my: "+ my +" 이겼다.");
		}else  {
 			System.out.println("com: "+com+ " my: "+ my +" 졌다.");
		}
// 샘 풀이 my - com 결과 음수 값이 포함되었다. 이를 양수로 전환 후 규칙을 찾는다.
		String result;	
		if(my==com ){
			result ="비겼다";
		}else if((my-com+3) % 3==1 ){ //3더기하기 대신 2를 더해도 괜찮다
			result ="이겼다.";
		}else{
 			result ="졌다.";
		}
		//초기화 해줘야함
		String myStr="";
		switch(my){
			case 0: myStr= "가위";
				break;
			case 1: myStr= "바위";
				break;
			case 2: myStr= "보";
				break;
		}
		//초기화 해줘야함
		String comStr="";
		switch(com){
			case 0: comStr= "가위";
				break;
			case 1: comStr= "바위";
				break;
			case 2: comStr= "보";
				break;
		}
 		System.out.println("나 "+ myStr+ " 컴 "+comStr +" 결과 "+result);
	}//main
}

//java SE  : developer edition
//	   EE  : serverSide edition 
//	   ME : micro edition (소형기기 요즘엔 거의 안써)




