package com.kitri.array;

public class ArrayTest2 {
	public static void main(String[] args) {
		Car car[] = new Car[6];
		car[0] = new Car("Cupe", "빨강", "현대");
		car[1] = new Car("쏘나타", "검정색", "기아");
		car[2] = new Car("K5", "흰색", "삼성");
		car[3] = new Car("아반떼", "은색", "현대");
		car[4] = new Car("니어로", "비둘기색", "기아");
		car[5] = new Car("싼타페", "검정색", "현대");
		
		for(int i=0; i<car.length; i++) {
			System.out.println(i+1+"번째구역: "+car[i].toString());
		}
		
		String name ="니어로";
//		String name ="QM5";
		boolean isExsist= false;
		//똑같은 이름의 자동차는 없다라는 전제하에.
		for(int i=0; i<car.length; i++) {
			if(car[i].getCarName().equals(name)  ) {
				System.out.println(car[i].getColor()+" "+name +"은 "+(i+1)+"번째에 있습니다.");
				isExsist= true;
				break; //쓸데없는 루프 방지 (만약 배열의 길이가 길면 성능에 큰 영향을 미칠 수 가있다.
			}
		}//end for
		if(isExsist==false) {
			System.out.println("QM5가 없습니다.");	
		}
		
		
		//샘 풀이 객체를 밖으로 꺼낸다.
		Car c= null;
		int count=0;
		//똑같은 이름의 자동차는 없다라는 전제하에.
		for(int i=0; i<car.length; i++) {
			if(car[i].getCarName().equals(name)  ) {
				c= car[i];
				count = i+1;
				isExsist= true;
				break; //쓸데없는 루프 방지 (만약 배열의 길이가 길면 성능에 큰 영향을 미칠 수 있다.)
			}
		}//end for
		if(c != null) {
			System.out.println("QM5가 없습니다.");	
		}else {
			System.out.println(c.getColor()+" "+name +"은 "+(count)+"번째에 있습니다.");
		}
		
	}//end main


}

