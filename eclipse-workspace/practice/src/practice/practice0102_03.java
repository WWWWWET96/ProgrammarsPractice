package practice;

import java.util.Arrays;
import java.util.Scanner;

class Solution3 {
	public static String solution(String[] participant, String[] completion) {
		Arrays.sort(completion);
		Arrays.sort(participant);
		String answer = ""; // 초기화
		
		for(int i =0; i<completion.length; i++)
		{
			if(!participant[i].equals(completion[i]))
				return participant[i];
		}
		
		return participant[completion.length];
			/* for(String s:participant) // iterator사용하여 for-each
		{
			int a = Arrays.binarySearch(completion, s);// completion에 s가 있으면 양수, 없으면 음수
			if(a<0)
				answer = s;
		}
	첫번째 방법
		 * for(int i = 0; i<participant.length; i++)
		{
			if((Arrays.asList(completion).contains(participant[i]))== false )
				answer = participant[i];
			
		Arrays.asList()는 말 그대로 배열을 list로 변경할때 사용
			 * asList()를 사용해서 객체를 만들 때 새로운 배열객체를 만드는 것이 아니라 원본배열의
			 * 주소값을 참조.
			 * asList()사용해서 내용 수정하면 원본 배열도 함께 바뀜
			 * 그러나 Array.asList()로 만든 List에 새로운 원소 추가하거나 삭제할 수 없음
		
			 * 
			 * 배열에서 찾고자 하는 문자열 찾을 때 수행시간 binarysearch가 가장 짧다고 함
		}*/
	
}
}
public class practice0102_03 extends Solution3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("participant:");
		Scanner scan1 = new Scanner(System.in);
		String s1 = scan1.nextLine();
		System.out.print("complement:");
		Scanner scan2 = new Scanner(System.in);
		String s2 = scan2.nextLine();
		
		
		String[] splitstr1 = s1.split(",");
		String[] splitstr2 = s2.split(",");
		
		/*System.out.println(Arrays.toString(splitstr1)); 
		그냥 System.out.println(splitst1);하면 쓰레기값 출력됨
		자바에서 배열 출력하려면 이런 식으로 출력하는 거 잊지말기!!
		*/
		System.out.print(Solution3.solution(splitstr1,splitstr2));
		
	}

}
