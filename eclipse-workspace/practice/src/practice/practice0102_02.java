package practice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Solution02{
	public static String[] solution(String[] strings, int n) {
		
		
		String[] answer = {};
		return answer;
	}
}
public class practice0102_02 extends Solution02{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("strings:");
		Scanner scan1 = new Scanner(System.in);
		String s = scan1.nextLine();
		String[] arr = s.split(",");
		
		System.out.print("n:");
		Scanner scan2 = new Scanner(System.in);
		int n = scan2.nextInt();
		
		
		System.out.println(Solution02.solution(arr,n));
		/*
		char[] arr = new char[splitstr.length]; // ���ڿ� ���� �迭 ����
		for(int i =0; i< splitstr.length; i++)
		{
			char charAt = splitstr[i].charAt(n); //���� �߿� �ε��� ��ġ(n) �ش�Ǵ� ���������ϴ� �Լ�
			arr[i]= charAt; // ���� ���� ����
			
		}
		*/
	
	
		
		
		
		
		
		

	}

}
