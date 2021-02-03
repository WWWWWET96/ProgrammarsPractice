package practice;

import java.util.Arrays;

/*
 * 문제 설명
n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

제한사항
주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
각 숫자는 1 이상 50 이하인 자연수입니다.
타겟 넘버는 1 이상 1000 이하인 자연수입니다.
입출력 예
numbers	target	return
[1, 1, 1, 1, 1]	3	5

지은이가 힌트줘서 푼 거: 재귀함수 이용(numbers,answer,target) // answer는 target이랑 비교할 수
int re(number[i], sum+number[i], target){
if(i == number.lenth()){
if(sum == target){ 
return 1;}
else return 0;
} 
sum=sum+number[i];
i++;
return re(number[i],sum.target) + re(number[i]*(-1), sum,target);

-> 문제? number[i]를 매개변수로 줄 수 없음!! number를 직접 이용해서 줘야하는데 추가로 i도 매개변수로 주면 음수일 때 계산 못함
}



 * */
class Solution0130_03{
	static int ReCall(int[] numbers, int sum, int target) {
		if(numbers.length == 0) {
			if(sum == target) { return 1;}
			else return 0;
		}
		return ReCall(Arrays.copyOfRange(numbers, 1, numbers.length) ,sum + numbers[0],target) + 
				ReCall(Arrays.copyOfRange(numbers, 1, numbers.length) ,sum - numbers[0],target);}
	 /*Arrays.copyOfRange통해 서브배열 다시 넣는 것. 매개변수로 넣을 때 sum을 더해서 늘려가는 것. 재귀함수 안에서 돌리면 양수 더할때와 음수 더할때를 
	  * 구분지을 수 없기에 저렇게 매개변수 통해 덧셈 이뤄지는 것
	  **/
	static int solution0130_03(int[] numbers, int target) {
		
		int answer = 0;
		 int sum=0;
		answer = ReCall(Arrays.copyOfRange(numbers, 1, numbers.length),numbers[0], target)+
				ReCall(Arrays.copyOfRange(numbers, 1, numbers.length), -numbers[0], target);
		return answer;
	}
}
public class practice0130_03 extends Solution0130_03{
	public static void main(String[] args) { 
		int[] numbers = {1,1,1,1,1};
		int target  = 3;
		
		System.out.println(solution0130_03(numbers, target));
	}
}
