package practice;

import java.util.Arrays;

/*
 * ���� ����
n���� ���� �ƴ� ������ �ֽ��ϴ�. �� ���� ������ ���ϰų� ���� Ÿ�� �ѹ��� ������� �մϴ�. ���� ��� [1, 1, 1, 1, 1]�� ���� 3�� ������� ���� �ټ� ����� �� �� �ֽ��ϴ�.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
����� �� �ִ� ���ڰ� ��� �迭 numbers, Ÿ�� �ѹ� target�� �Ű������� �־��� �� ���ڸ� ������ ���ϰ� ���� Ÿ�� �ѹ��� ����� ����� ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
�־����� ������ ������ 2�� �̻� 20�� �����Դϴ�.
�� ���ڴ� 1 �̻� 50 ������ �ڿ����Դϴ�.
Ÿ�� �ѹ��� 1 �̻� 1000 ������ �ڿ����Դϴ�.
����� ��
numbers	target	return
[1, 1, 1, 1, 1]	3	5

�����̰� ��Ʈ�༭ Ǭ ��: ����Լ� �̿�(numbers,answer,target) // answer�� target�̶� ���� ��
int re(number[i], sum+number[i], target){
if(i == number.lenth()){
if(sum == target){ 
return 1;}
else return 0;
} 
sum=sum+number[i];
i++;
return re(number[i],sum.target) + re(number[i]*(-1), sum,target);

-> ����? number[i]�� �Ű������� �� �� ����!! number�� ���� �̿��ؼ� ����ϴµ� �߰��� i�� �Ű������� �ָ� ������ �� ��� ����
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
	 /*Arrays.copyOfRange���� ����迭 �ٽ� �ִ� ��. �Ű������� ���� �� sum�� ���ؼ� �÷����� ��. ����Լ� �ȿ��� ������ ��� ���Ҷ��� ���� ���Ҷ��� 
	  * �������� �� ���⿡ ������ �Ű����� ���� ���� �̷����� ��
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
