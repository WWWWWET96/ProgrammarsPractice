import java.util.Set;
import java.util.TreeSet;

/*���� ����
���ڸ� ���ڰ� ���� ���� ������ ������ֽ��ϴ�. ����� ���� ������ �ٿ� �Ҽ��� �� �� ���� �� �ִ��� �˾Ƴ��� �մϴ�.

�� ���� ������ ���� ���ڰ� ���� ���ڿ� numbers�� �־����� ��, ���� �������� ���� �� �ִ� �Ҽ��� �� ������ return �ϵ��� solution �Լ��� �ϼ����ּ���.

���ѻ���
numbers�� ���� 1 �̻� 7 ������ ���ڿ��Դϴ�.
numbers�� 0~9���� ���ڸ����� �̷���� �ֽ��ϴ�.
013�� 0, 1, 3 ���ڰ� ���� ���� ������ ������ִٴ� �ǹ��Դϴ�.
����� ��
numbers	return
17	3
011	2
����� �� ����
���� #1
[1, 7]���δ� �Ҽ� [7, 17, 71]�� ���� �� �ֽ��ϴ�.

���� #2
[0, 1, 1]���δ� �Ҽ� [11, 101]�� ���� �� �ֽ��ϴ�.

11�� 011�� ���� ���ڷ� ����մϴ�.

2������ ���-> 1.���� �� �ִ� ��� ���� ���� ����� ���: ���� �̿� -> n���� ���� �� r���� ���� ������ ����� ��/ ������ȿ
�������� {1,2,3}�� {1,3,2}�� {2,1,3}�� ��� �ٸ� ��

https://minhamina.tistory.com/37

depth�� result�� �ε����� �����Ѵٰ� ����?
 2.�Ҽ� �˻��ϴ� ���
 (��1��,)
(��1��,��2��)
Set<Integer> TreeNums = new TreeSet<>();
011 11
��011�� -> 11

 
 treeset-> ���°� hashsetó�� ���. ��� ����Ʈ���� �˻����� �� ����
*/
public class project0204_02  {
	static Set<Integer> TreeNums = new TreeSet<>(); //set�� �ߺ� �� ���� �� ����. treeset�� �˻� �� ��Ȱ
	public static void permutations(String str, String nums, int depth) {

		if(str.length() == depth) // ������ �� ����
		{
			TreeNums.add(Integer.parseInt(str));
		}
	else {
		TreeNums.add(Integer.parseInt(str)); 
		/*�츮�� 3���� 3���� ���� ������ ���°� �ƴ϶� 3���� 1���̾��� ��, 2��~�� ������
		 * �׷��� ������ �̾Ҵ� ��� ���յ� �� TreeNums�� �־���ϴϱ� else�϶��� TreeNums�� �����ؾ��ϴ°�
		 * ���⼭ ���� �߿��Ѱ� SET�� ��ٴ� ����
		 * set�� �Ⱦ��� �׳� �迭 � �����ϸ� 011, 11�� �ٸ� ���ڷ� ���� ����!!
		 * �׸��� ���� string�̿�� "011"�� "11"�� �ٸ� ������ �������� 
		 * �׷��⿡ ���⼭ integer�� �ٲ�ٴ� �� �ſ� �߿�!!!!!*/
		for(int i =0; i<nums.length();i++) {
			permutations(str+nums.charAt(i), nums.substring(0, i)+
					nums.substring(i+1, nums.length()), depth+1);
		}
	}
		}
	
	
	public static int solution0204_02(String numbers) {
		int answer = 0;
		String[] nums = numbers.split(""); 
		int n = numbers.length();
		
		for(int i = 0; i<n; i++) {
			permutations(""+numbers.charAt(i), numbers.substring(0, i)+
					numbers.substring(i+1, n), n);
		}
		
		for(int i:TreeNums) {
			if(i !=2 && (i&1) == 0) continue;
			int div = 3; int value = i;
			int sqrtNums = (int)Math.sqrt(i);
			while(sqrtNums >= div) {
				if(i % div == 0) {value = 1; break;}
				div += 1;
				
			}
			answer += (value ==1)?0:1; //���׿����� ���. value�� 1�̸�(�Ҽ��� �ƴϸ�) 0, 1�̾ƴϸ� 1
		}
		return answer;
	}
	public static void main(String[] args) {
		String numbers = "011";

		System.out.println(solution0204_02(numbers));
	}
		
		
		
	}

