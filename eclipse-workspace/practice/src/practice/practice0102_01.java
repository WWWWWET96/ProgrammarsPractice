package practice;

import java.util.Scanner;

class Solution0102_01 {
	public static boolean solution(String s) {
		boolean answer = true;
		if(s.length() == 4 || s.length() ==6) // s문자열 길이 4 혹은 6인 조건
		{
			if(s.matches("[0-9]+$")) {
				return answer;
			}
			else
				return !answer;
		}
		return !answer;
		
	}
}
public class practice0102_01 extends Solution0102_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s;
		System.out.print("문자열 입력:");
		java.util.Scanner scan = new Scanner(System.in);
		
		s= scan.nextLine();
		
		System.out.println(Solution0102_01.solution(s));
		
		
	}

}
