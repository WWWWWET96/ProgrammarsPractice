package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution0109_03{
	public static int[] solution0109_03(int[] array, int[][]commands) {
		int[] answer = {};
		answer=new int[commands.length]; 
		String S0 = Arrays.toString(array).replaceAll("[^0-9]", "");// ���ڿ� ������ ���� string���� . replaceAll�ϸ� ���ڸ� �Էµ�
		String S1,S2;
		ArrayList <Character> arr2 = new ArrayList<>();
		for(int m=0; m<commands.length; m++) {
			S1 = S0;
			arr2.clear(); // ����Ʈ �ʱ�ȭ
			int i = commands[m][0];
			int j = commands[m][1];
			int k = commands[m][2];
			
			 S2 = S1.substring(i-1, j); // ���ڿ� �ڸ���
			 
			 for(int p = 0 ; p<S2.length(); p++) // ����Ʈ�� �� �ֱ�
			 {
				 char temp = S2.charAt(p);
				 arr2.add(temp);
			 }
			Collections.sort(arr2); // ����Ʈ ����			
			answer[m] = arr2.get(k-1) - '0'; //string����Ʈ�� �ִ� �� ������ ���� �� ������ IntegerŬ������ parseInt Ȥ�� ValueOf�� �̾ƾ���
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

/*�ʱ�
 * int[] array = {1,5,2,6,3,7,4};
 * String s1 = Arrays.toString(array).replaceAll("[^0-9]", "");
	String s2 = s1.substring(2,5);
	System.out.println(s2); // �ϸ� ���� ���ϴ´�� 263���
		
	$$$$$�Ǽ��ߴ� ��
	String s1 = Arrays.toString(array);
	String s2 = s1.substring(2,5);
	System.out.println(s2);
	
	�̷����ϸ� ","�� ���� ��µ�!!!!!!!
	
	
	=> ���ڹ迭���� ���ڿ��� �ٲ� �� �ڿ� replaceAll�������
 * 
 * */


