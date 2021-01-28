import java.util.Arrays;
import java.util.List;

/*문제 설명 https://programmers.co.kr/learn/courses/30/lessons/42577
전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

구조대 : 119
박준영 : 97 674 223
지영석 : 11 9552 4421
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

제한 사항
phone_book의 길이는 1 이상 1,000,000 이하입니다.
각 전화번호의 길이는 1 이상 20 이하입니다.
리스트로 바꿔서 제일 작은 숫자길이만큼 나머지 길이 다 잘라서 같은지 비교?

*
*sort를 맨 처음 해줄 것
*Array정렬할 때 이 방법 많이 씀
*Arrays.sort(phone_book, (x, y)->Integer.compare(x.length(), y.length()));
*
*
 이게 내가 풀었던 문제풀이. 지은이와 비슷하게 푼거같지만 맨 처음 sort를 안해주었음
 접두어만 보면 되니까 문자열로 생각하면 길이만 보면 되는것임. 
 so, 길이 짧은 것, 즉 숫자가 작은 것부터 비교하면 효율성 올라감. so sort해준 것
 람다식 이용하여 문자열 길이에 따라 sort한 것.
 
 또 하나의 차이점은 내가 푼 풀이를 보면 answer변수 통 풀고, break를 걸었는데 효율성 오류남 ㅡㅡ;
 -> 변수 지우고 return값 바로 주니까 통과댐 
효율성 문제가 변수를 많이 남용하거나 하면 오류뜸

class Solution0118_02{
	public static boolean solution0118_02(String[] phone_book) {
		Arrays.sort(phone_book, (x,y) -> Integer.compare(x.length(), y.length()));
		boolean answer = true;
	
		for(int i=0; i<phone_book.length-1; i++) {
			for(int j=i+1; j<phone_book.length; j++) {
				if(phone_book[j].startsWith(phone_book[i]) == true) // 만약 list.get(i)로시작하는 list.get(j)있으면 반환값은 true
				{
					answer = false;
					break; // 하나라도 있으면 나머지 볼 필요 없음 return값만 보는거니까
				}
			}
		}	
		return answer;
		
	}
}*/

class Solution0118_02{
	public static boolean solution0118_02(String[] phone_book) {
		  Arrays.sort(phone_book, (x,y) -> Integer.compare(x.length(), y.length()));
	     
	       	for(int i=0; i<phone_book.length-1; i++) {
				for(int j=i+1; j<phone_book.length; j++) {
					if(phone_book[j].startsWith(phone_book[i]) == true) // 만약 list.get(i)로시작하는 list.get(j)있으면 반환값은 true
					{
						return false; // 어떤 번호가 다른 번호의 접두어인 경우 false리턴
					}
				}
			}	
	        return true; // 아닌경우 true 리턴
		
	}
}
public class practice0118_02 extends Solution0118_02{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"12", "123", "1235", "567", "88"};
		
		System.out.println(solution0118_02(s));
	}

}
