package practice;

class Solution0112_02{
	static boolean solution0112_02(String s) {
		boolean answer = true;
		int pnum=0, ynum=0; //p����, y���� �� ����

		for(int i=0; i<s.length(); i++) {
			char temp = s.charAt(i); //���ڿ����� �� ���ھ� ��ȯ
	
			if(temp == 'p' || temp =='P') pnum++;
			if(temp == 'y' || temp =='Y') ynum++;
		}
		if(pnum ==0 && ynum ==0)// 'p'�� 'y'�� ��� �ϳ��� ���°��
			return answer; //�׻� true����
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
