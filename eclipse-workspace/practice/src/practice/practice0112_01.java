package practice;
/*문제: 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 
 * 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
 * 제한조건: n은 10,000,000,000이하인 자연수입니다.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution0112_01{
	public static int[] solution0112_01(long n) {
		int[] answer = {};
		String s = String.valueOf(n); // 문자열로 변환
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
