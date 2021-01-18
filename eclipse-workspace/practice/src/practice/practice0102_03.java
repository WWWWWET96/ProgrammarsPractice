package practice;

import java.util.Arrays;
import java.util.Scanner;

class Solution3 {
	public static String solution(String[] participant, String[] completion) {
		Arrays.sort(completion);
		Arrays.sort(participant);
		String answer = ""; // �ʱ�ȭ
		
		for(int i =0; i<completion.length; i++)
		{
			if(!participant[i].equals(completion[i]))
				return participant[i];
		}
		
		return participant[completion.length];
			/* for(String s:participant) // iterator����Ͽ� for-each
		{
			int a = Arrays.binarySearch(completion, s);// completion�� s�� ������ ���, ������ ����
			if(a<0)
				answer = s;
		}
	ù��° ���
		 * for(int i = 0; i<participant.length; i++)
		{
			if((Arrays.asList(completion).contains(participant[i]))== false )
				answer = participant[i];
			
		Arrays.asList()�� �� �״�� �迭�� list�� �����Ҷ� ���
			 * asList()�� ����ؼ� ��ü�� ���� �� ���ο� �迭��ü�� ����� ���� �ƴ϶� �����迭��
			 * �ּҰ��� ����.
			 * asList()����ؼ� ���� �����ϸ� ���� �迭�� �Բ� �ٲ�
			 * �׷��� Array.asList()�� ���� List�� ���ο� ���� �߰��ϰų� ������ �� ����
		
			 * 
			 * �迭���� ã���� �ϴ� ���ڿ� ã�� �� ����ð� binarysearch�� ���� ª�ٰ� ��
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
		�׳� System.out.println(splitst1);�ϸ� �����Ⱚ ��µ�
		�ڹٿ��� �迭 ����Ϸ��� �̷� ������ ����ϴ� �� ��������!!
		*/
		System.out.print(Solution3.solution(splitstr1,splitstr2));
		
	}

}
