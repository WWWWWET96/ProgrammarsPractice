package practice_alone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*���� ����
0 �Ǵ� ���� ������ �־����� ��, ������ �̾� �ٿ� ���� �� �ִ� ���� ū ���� �˾Ƴ� �ּ���.

���� ���, �־��� ������ [6, 10, 2]��� [6102, 6210, 1062, 1026, 2610, 2106]�� ���� �� �ְ�, ���� ���� ū ���� 6210�Դϴ�.

0 �Ǵ� ���� ������ ��� �迭 numbers�� �Ű������� �־��� ��, ������ ���ġ�Ͽ� ���� �� �ִ� ���� ū ���� ���ڿ��� �ٲپ� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���� ����
numbers�� ���̴� 1 �̻� 100,000 �����Դϴ�.
numbers�� ���Ҵ� 0 �̻� 1,000 �����Դϴ�.
������ �ʹ� Ŭ �� ������ ���ڿ��� �ٲپ� return �մϴ�.

*
���� �� �ִ� ����� ��??
���� �ٸ� n���� ���� �� n���� �ߺ����� �ʰ� �����Ͽ� ������� �������� �� ����� �� n*(n-1)*...*1


�ʿ��� �迭�� ���� ������ ���� �迭, ó�� numbers�� list�� �ٲ㼭 ���� �ϳ��� �迭�� �ְ� ����


*/
class Solutionpc_1{
	public static String solutionpc_1(int[] numbers) {
		ArrayList <String> alist = new ArrayList<>(); //���� ������ ���� �迭
		ArrayList <String> blist = new ArrayList<>(); // numbers�� �ִ� ���ڸ� ���� �迭
		
		for(int p:numbers) {
			blist.add(Integer.toString(p));
		} // �迭 �ϳ��� �ֱ�i
		
		
		do { // blist�� ���� ���� ������
			String stemp = "0"; // �迭���� �� ���ڸ� ���ؼ� ���� ū ��. �迭�� �� ��
			char temp = '0'; // �� ���ڸ� �� ���� �� ���� ū �� �� char
			int n=0;
			
			for(String s : blist) {
			char c = s.charAt(0);
			
			if(c > temp) { // �� ���ڸ� �� ��
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
