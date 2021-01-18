package practice;

class Solution0112_02{
	static boolean solution0112_02(String s) {
		boolean answer = true;
		int pnum=0, ynum=0; //p갯수, y갯수 셀 변수

		for(int i=0; i<s.length(); i++) {
			char temp = s.charAt(i); //문자열에서 한 글자씩 반환
	
			if(temp == 'p' || temp =='P') pnum++;
			if(temp == 'y' || temp =='Y') ynum++;
		}
		if(pnum ==0 && ynum ==0)// 'p'와 'y'가 모두 하나도 없는경우
			return answer; //항상 true리턴
		if(pnum == ynum)
			return answer;
		else 
			return !answer;
	}
}
public class practice0112_02 extends Solution0112_02{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Pyy";
		
		System.out.println(solution0112_02(s));
	
	}

}
