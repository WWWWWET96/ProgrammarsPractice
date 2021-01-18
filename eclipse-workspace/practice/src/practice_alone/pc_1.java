package practice_alone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*문제 설명
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

*
만들 수 있는 경우의 수??
서로 다른 n개의 원소 중 n개를 중복하지 않고 선택하여 순서대로 나열했을 때 경우의 수 n*(n-1)*...*1


필요한 배열은 정답 순서로 넣을 배열, 처음 numbers를 list로 바꿔서 원소 하나씩 배열에 넣고 제거


*/
class Solutionpc_1{
	public static String solutionpc_1(int[] numbers) {
		ArrayList <String> alist = new ArrayList<>(); //정답 순서로 넣을 배열
		ArrayList <String> blist = new ArrayList<>(); // numbers에 있는 숫자를 넣을 배열
		
		for(int p:numbers) {
			blist.add(Integer.toString(p));
		} // 배열 하나씩 넣기i
		
		
		do { // blist에 원소 없을 때까지
			String stemp = "0"; // 배열에서 맨 앞자리 비교해서 제일 큰 수. 배열에 들어갈 수
			char temp = '0'; // 맨 앞자리 수 비교할 때 제일 큰 수 들어갈 char
			int n=0;
			
			for(String s : blist) {
			char c = s.charAt(0);
			
			if(c > temp) { // 맨 앞자리 수 비교
				temp = c;
				stemp = s;
			}
			else if(c == temp) {
				if(s.charAt(1) > stemp.charAt(1))
				{
					stemp = s;
				}
				else if(s.charAt(1) == stemp.charAt(1)) {
					if(s.charAt(2) > stemp.charAt(2))
					{
						stemp = s;
					}
				}
			}
			}
			alist.add(stemp);
			blist.remove(stemp);
		
		}while(blist.size() !=0);
		
		String answer = "";
		answer = alist.toString();
		return answer;
	}
	
}
public class pc_1 extends Solutionpc_1{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 int[] a = {3,30,34,5,9};
	
	 System.out.println(solutionpc_1(a));
	}

}
