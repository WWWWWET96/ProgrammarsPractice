package practice;

import java.util.Arrays;

class Solution0112_03{
	public static int[] solution0112_03(int[] prices) {
		int[] answer = {};
		answer = new int[prices.length];
		
		for(int i=0; i<prices.length; i++) {
			int sec=0;//���� �������� ���� �Ⱓ ������ ����
			for(int j = i+1; j<prices.length; j++) {
				if(prices[i] > prices[j]) { // �� �� ���Һ��̸� �� �� �迭 �� �ʿ� �����ϱ�
					sec++;
					break; // break�ɾ ������
					}
				sec++; //���Ҽ� ���� ��� �����ؾߴϱ�
			}
			answer[i] = sec;
		}
		return answer;
	}
}
public class practice0112_03 extends Solution0112_03 {
	public static void main(String[] args) {
		int[] prices = {1,2,3,2,3};
		
		System.out.println(Arrays.toString(solution0112_03(prices)));
		// TODO Auto-generated method stub

	}

}
