import java.util.ArrayList;
import java.util.Arrays;

/*문제 설명  https://programmers.co.kr/learn/courses/30/lessons/42586
프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.

또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.

먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

제한 사항
작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
작업 진도는 100 미만의 자연수입니다.
작업 속도는 100 이하의 자연수입니다.
배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
입출력 예
progresses	speeds	return
[93, 30, 55]	[1, 30, 5]	[2, 1]
[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]

100%을 채워야 함으로 {(100-progresses)/speed}반올림한 후 배열에 다 넣기
=> progresses, speeds가 int형이니까 몫, 나머지밖에 못 구함. 그러나 내가 원하는 건 소수점까지 
double형인 temp변수 이용하여 강제형변환 통해 값 저장한 후 Math.ceil(temp)통해 올림.
**Math.floor(temp) //버림
**Math.abs(temp) //절대값
**Math.round(temp) //반올림 
날짜를 세는 변수 count 두고, 배포가능한 기능을 세는 func_count변수 두기.
count가 그 다음 배열에 있는 숫자보다 작을 때까지 func_count증가
count 값이 변경되면, 즉 그 다음 배열에 있는 숫자가 더 크면 return배열에 저장 후 func_count 초기화

*
*=> 내가 헷갈려하는 것 int와 Integer 차이
*
***ArrayList와 LinkedList 차이
*인덱스를 이용해서 데이터를 가져오는 것이 빈번하다면 ArrayList가 훨씬 빠름.
* 하지만 데이터의 추가/삭제가 빈번하다면 LinkedList가 훨씬 효과적.*/

class Solution0118_03{
	public static int[] solution0118_03(int[] progresses, int[] speeds) {
		int[] answer = {};
		ArrayList<Integer> temp_answer = new ArrayList<>(); //answer에 값 삽입위한 임시 list. answer그대로 사용하려면 배열크기 알아야하니까 임시로 arraylist에 넣는 것
		int[] date = new int[progresses.length]; // 각 기능이 작업이 끝나기까지 남은 일수
		
		for(int i = 0; i< progresses.length; i++) {
			date[i] = (int)(Math.ceil((float)(100-progresses[i])/(float)(speeds[i]))); // 작업이 끝나기까지 남은 일수 계산, 삽입
		}// date배열 완성
		int num=0; // answer의 크기 알기 위한 변수
		int count=date[0]; // 일수를 비교하기 위한 변수
		int func_count=1; // 일자에 따라 배포되는 기능의 수 세기위한 변수
		
		for(int j = 1; j<date.length; j++) {
			int temp = count; // count의 값 변경이 있었는지 확인하기 위한 임시변수
			if(count < date[j]) {
				count = date[j];
				temp_answer.add(func_count);
				func_count = 1;
				num++;
			}
			else { // count > date[i]
				func_count ++;
			}
			/*if(temp != count) { // 배포요일의 변화가 생겼다는 뜻. so func_count도 초기화
				temp_answer.add(func_count);
				func_count = 1;
				num++;
			 }
			 ->지은 왈: temp랑 count가 같지 않다는게 count<date[j], 첫 번째 if문과 같은 것 
			 so 묶어버림
			 */
		
	}
		temp_answer.add(func_count);// 제일 마지막 껀 계산했지만 안들어갔음. 이건 직접 넣어주기
		answer = new int[num]; // 여기서 num은 answer크기의 -1임. 왜냐면 첫번째 if문에서 num증가가 한 번 덜 일어나니까
		answer = temp_answer.stream().mapToInt(Integer::valueOf).toArray();// 여기서 알아서 answer배열의 크기 증감시키는듯
		return answer;
		
		/*진짜 중요!!! Wrapper인 Integer를 int배열인 answer에 넣기 위해선
		 * answer = temp_answer.stream().mapToInt(Integer::valueOf).toArray();
		 * 
		 * 자주 쓰이니까 외우기
		 * 
		 * -> stream은 컬렉션, 배열등의 저장 요소를 하나씩 참조하며 함수형 인터페이스(람다식)를 적용하며 
		 * 반복적으로 처리할 수 있도록 해주는 기능. 자바8이전엔 for이용해서 하나씩 넣어야했음
		 * 
		 * */
}
}
public class practice0118_03 extends Solution0118_03{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		System.out.println(Arrays.toString(solution0118_03(progresses, speeds)));

}
}
