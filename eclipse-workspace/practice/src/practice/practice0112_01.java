package practice;
/*����: �ڿ��� n�� ������ �� �ڸ� ���ڸ� ���ҷ� ������ �迭 ���·� �������ּ���. 
 * ������� n�� 12345�̸� [5,4,3,2,1]�� �����մϴ�.
 * ��������: n�� 10,000,000,000������ �ڿ����Դϴ�.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution0112_01{
	public static int[] solution0112_01(long n) {
		int[] answer = {};
		String s = String.valueOf(n); // ���ڿ��� ��ȯ
		ArrayList<Character> list = new ArrayList<>();
		for(int i=0; i<s.length(); i++) {
			list.add(s.charAt(i)); 
		}
		
		Collections.reverse(list);
		answer = new int[s.length()];
		for(int j=0; j<s.length(); j++) {
			answer[j] = list.get(j)-'0';
		}
		
		
		return answer;
	}
}
public class practice0112_01 extends Solution0112_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n = 12345;
		
		System.out.println(Arrays.toString(solution0112_01(n)));
	}

}
