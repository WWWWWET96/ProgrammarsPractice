package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution0109_03{
	public static int[] solution0109_03(int[] array, int[][]commands) {
		int[] answer = {};
		answer=new int[commands.length]; 
		String S0 = Arrays.toString(array).replaceAll("[^0-9]", "");// 문자열 나누기 위해 string으로 . replaceAll하면 숫자만 입력됨
		String S1,S2;
		ArrayList <Character> arr2 = new ArrayList<>();
		for(int m=0; m<commands.length; m++) {
			S1 = S0;
			arr2.clear(); // 리스트 초기화
			int i = commands[m][0];
			int j = commands[m][1];
			int k = commands[m][2];
			
			 S2 = S1.substring(i-1, j); // 문자열 자르기
			 
			 for(int p = 0 ; p<S2.length(); p++) // 리스트에 값 넣기
			 {
				 char temp = S2.charAt(p);
				 arr2.add(temp);
			 }
			Collections.sort(arr2); // 리스트 정렬			
			answer[m] = arr2.get(k-1) - '0'; //string리스트에 있는 값 정수로 뽑을 때 저렇게 Integer클래스의 parseInt 혹은 ValueOf로 뽑아야함
		}
		return answer;
	
}
}
public class practice0109_03 extends Solution0109_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,5,2,6,3,7,4,5,6,6};
		
		int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}, {2,6,2}};
	
			
		
		System.out.println(Arrays.toString(solution0109_03(array, commands)));
		}
		

		
		
	

}

/*필기
 * int[] array = {1,5,2,6,3,7,4};
 * String s1 = Arrays.toString(array).replaceAll("[^0-9]", "");
	String s2 = s1.substring(2,5);
	System.out.println(s2); // 하면 내가 원하는대로 263출력
		
	$$$$$실수했던 것
	String s1 = Arrays.toString(array);
	String s2 = s1.substring(2,5);
	System.out.println(s2);
	
	이렇게하면 ","도 같이 출력됨!!!!!!!
	
	
	=> 숫자배열에서 문자열로 바꿀 때 뒤에 replaceAll해줘야함
 * 
 * */


