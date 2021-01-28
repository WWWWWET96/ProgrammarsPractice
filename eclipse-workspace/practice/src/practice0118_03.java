import java.util.ArrayList;
import java.util.Arrays;

/*���� ����  https://programmers.co.kr/learn/courses/30/lessons/42586
���α׷��ӽ� �������� ��� ���� �۾��� ���� ���Դϴ�. �� ����� ������ 100%�� �� ���񽺿� �ݿ��� �� �ֽ��ϴ�.

��, �� ����� ���߼ӵ��� ��� �ٸ��� ������ �ڿ� �ִ� ����� �տ� �ִ� ��ɺ��� ���� ���ߵ� �� �ְ�, �̶� �ڿ� �ִ� ����� �տ� �ִ� ����� ������ �� �Բ� �����˴ϴ�.

���� �����Ǿ�� �ϴ� ������� �۾��� ������ ���� ���� �迭 progresses�� �� �۾��� ���� �ӵ��� ���� ���� �迭 speeds�� �־��� �� �� �������� �� ���� ����� �����Ǵ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.

���� ����
�۾��� ����(progresses, speeds�迭�� ����)�� 100�� �����Դϴ�.
�۾� ������ 100 �̸��� �ڿ����Դϴ�.
�۾� �ӵ��� 100 ������ �ڿ����Դϴ�.
������ �Ϸ翡 �� ���� �� �� ������, �Ϸ��� ���� �̷�����ٰ� �����մϴ�. ���� ��� �������� 95%�� �۾��� ���� �ӵ��� �Ϸ翡 4%��� ������ 2�� �ڿ� �̷�����ϴ�.
����� ��
progresses	speeds	return
[93, 30, 55]	[1, 30, 5]	[2, 1]
[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]

100%�� ä���� ������ {(100-progresses)/speed}�ݿø��� �� �迭�� �� �ֱ�
=> progresses, speeds�� int���̴ϱ� ��, �������ۿ� �� ����. �׷��� ���� ���ϴ� �� �Ҽ������� 
double���� temp���� �̿��Ͽ� ��������ȯ ���� �� ������ �� Math.ceil(temp)���� �ø�.
**Math.floor(temp) //����
**Math.abs(temp) //���밪
**Math.round(temp) //�ݿø� 
��¥�� ���� ���� count �ΰ�, ���������� ����� ���� func_count���� �α�.
count�� �� ���� �迭�� �ִ� ���ں��� ���� ������ func_count����
count ���� ����Ǹ�, �� �� ���� �迭�� �ִ� ���ڰ� �� ũ�� return�迭�� ���� �� func_count �ʱ�ȭ

*
*=> ���� �򰥷��ϴ� �� int�� Integer ����
*
***ArrayList�� LinkedList ����
*�ε����� �̿��ؼ� �����͸� �������� ���� ����ϴٸ� ArrayList�� �ξ� ����.
* ������ �������� �߰�/������ ����ϴٸ� LinkedList�� �ξ� ȿ����.*/

class Solution0118_03{
	public static int[] solution0118_03(int[] progresses, int[] speeds) {
		int[] answer = {};
		ArrayList<Integer> temp_answer = new ArrayList<>(); //answer�� �� �������� �ӽ� list. answer�״�� ����Ϸ��� �迭ũ�� �˾ƾ��ϴϱ� �ӽ÷� arraylist�� �ִ� ��
		int[] date = new int[progresses.length]; // �� ����� �۾��� ��������� ���� �ϼ�
		
		for(int i = 0; i< progresses.length; i++) {
			date[i] = (int)(Math.ceil((float)(100-progresses[i])/(float)(speeds[i]))); // �۾��� ��������� ���� �ϼ� ���, ����
		}// date�迭 �ϼ�
		int num=0; // answer�� ũ�� �˱� ���� ����
		int count=date[0]; // �ϼ��� ���ϱ� ���� ����
		int func_count=1; // ���ڿ� ���� �����Ǵ� ����� �� �������� ����
		
		for(int j = 1; j<date.length; j++) {
			int temp = count; // count�� �� ������ �־����� Ȯ���ϱ� ���� �ӽú���
			if(count < date[j]) {
				count = date[j];
				temp_answer.add(func_count);
				func_count = 1;
				num++;
			}
			else { // count > date[i]
				func_count ++;
			}
			/*if(temp != count) { // ���������� ��ȭ�� ����ٴ� ��. so func_count�� �ʱ�ȭ
				temp_answer.add(func_count);
				func_count = 1;
				num++;
			 }
			 ->���� ��: temp�� count�� ���� �ʴٴ°� count<date[j], ù ��° if���� ���� �� 
			 so �������
			 */
		
	}
		temp_answer.add(func_count);// ���� ������ �� ��������� �ȵ���. �̰� ���� �־��ֱ�
		answer = new int[num]; // ���⼭ num�� answerũ���� -1��. �ֳĸ� ù��° if������ num������ �� �� �� �Ͼ�ϱ�
		answer = temp_answer.stream().mapToInt(Integer::valueOf).toArray();// ���⼭ �˾Ƽ� answer�迭�� ũ�� ������Ű�µ�
		return answer;
		
		/*��¥ �߿�!!! Wrapper�� Integer�� int�迭�� answer�� �ֱ� ���ؼ�
		 * answer = temp_answer.stream().mapToInt(Integer::valueOf).toArray();
		 * 
		 * ���� ���̴ϱ� �ܿ��
		 * 
		 * -> stream�� �÷���, �迭���� ���� ��Ҹ� �ϳ��� �����ϸ� �Լ��� �������̽�(���ٽ�)�� �����ϸ� 
		 * �ݺ������� ó���� �� �ֵ��� ���ִ� ���. �ڹ�8������ for�̿��ؼ� �ϳ��� �־������
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
