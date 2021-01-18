package practice;

import java.util.Scanner;

class Solution0109_01{
	public static String solution(String s) {
		String answer = "";
		int len = s.length();
		if(len %2 != 0)  // 글자 수가 음수라면
			answer =  s.substring(((len-1)/2),(((len-1)/2)+1) ); //인덱스 가운데 char출력
		
		else //글자 수가 양수라면
			answer = s.substring(((len-1)/2),(((len-1)/2)+2) );//인덱스 가운데 두 개의 char출력
		
		return answer;
	}
}
public class practice0109_01 extends Solution0109_01{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("String:");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
	
		System.out.println(Solution0109_01.solution(s));
	}

}
