import java.util.Arrays;
import java.util.List;

/*���� ���� https://programmers.co.kr/learn/courses/30/lessons/42577
��ȭ��ȣ�ο� ���� ��ȭ��ȣ ��, �� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 �ִ��� Ȯ���Ϸ� �մϴ�.
��ȭ��ȣ�� ������ ���� ���, ������ ��ȭ��ȣ�� �������� ��ȭ��ȣ�� ���λ��Դϴ�.

������ : 119
���ؿ� : 97 674 223
������ : 11 9552 4421
��ȭ��ȣ�ο� ���� ��ȭ��ȣ�� ���� �迭 phone_book �� solution �Լ��� �Ű������� �־��� ��, � ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 ������ false�� �׷��� ������ true�� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���� ����
phone_book�� ���̴� 1 �̻� 1,000,000 �����Դϴ�.
�� ��ȭ��ȣ�� ���̴� 1 �̻� 20 �����Դϴ�.
����Ʈ�� �ٲ㼭 ���� ���� ���ڱ��̸�ŭ ������ ���� �� �߶� ������ ��?

*
*sort�� �� ó�� ���� ��
*Array������ �� �� ��� ���� ��
*Arrays.sort(phone_book, (x, y)->Integer.compare(x.length(), y.length()));
*
*
 �̰� ���� Ǯ���� ����Ǯ��. �����̿� ����ϰ� Ǭ�Ű����� �� ó�� sort�� �����־���
 ���ξ ���� �Ǵϱ� ���ڿ��� �����ϸ� ���̸� ���� �Ǵ°���. 
 so, ���� ª�� ��, �� ���ڰ� ���� �ͺ��� ���ϸ� ȿ���� �ö�. so sort���� ��
 ���ٽ� �̿��Ͽ� ���ڿ� ���̿� ���� sort�� ��.
 
 �� �ϳ��� �������� ���� Ǭ Ǯ�̸� ���� answer���� �� Ǯ��, break�� �ɾ��µ� ȿ���� ������ �Ѥ�;
 -> ���� ����� return�� �ٷ� �ִϱ� ����� 
ȿ���� ������ ������ ���� �����ϰų� �ϸ� ������

class Solution0118_02{
	public static boolean solution0118_02(String[] phone_book) {
		Arrays.sort(phone_book, (x,y) -> Integer.compare(x.length(), y.length()));
		boolean answer = true;
	
		for(int i=0; i<phone_book.length-1; i++) {
			for(int j=i+1; j<phone_book.length; j++) {
				if(phone_book[j].startsWith(phone_book[i]) == true) // ���� list.get(i)�ν����ϴ� list.get(j)������ ��ȯ���� true
				{
					answer = false;
					break; // �ϳ��� ������ ������ �� �ʿ� ���� return���� ���°Ŵϱ�
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
					if(phone_book[j].startsWith(phone_book[i]) == true) // ���� list.get(i)�ν����ϴ� list.get(j)������ ��ȯ���� true
					{
						return false; // � ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��� false����
					}
				}
			}	
	        return true; // �ƴѰ�� true ����
		
	}
}
public class practice0118_02 extends Solution0118_02{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"12", "123", "1235", "567", "88"};
		
		System.out.println(solution0118_02(s));
	}

}
