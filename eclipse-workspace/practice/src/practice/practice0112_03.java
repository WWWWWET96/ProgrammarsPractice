package practice;

import java.util.Arrays;

class Solution0112_03{
	public static int[] solution0112_03(int[] prices) {
		int[] answer = {};
		answer = new int[prices.length];
		
		for(int i=0; i<prices.length; i++) {
			int sec=0;//값이 떨어지지 않은 기간 저장할 변수
			for(int j = i+1; j<prices.length; j++) {
				if(prices[i] > prices[j]) { // 한 번 감소보이면 그 뒷 배열 볼 필요 없으니까
					sec++;
					break; // break걸어서 나가기
					}
				sec++; //감소세 없는 경우 증가해야니까
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
