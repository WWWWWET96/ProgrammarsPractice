/*���� ����
���� ��ų�̶� � ��ų�� ���� ���� ���� ����� �ϴ� ��ų�� ���մϴ�.

���� ��� ���� ��ų ������ ����ũ �� ����Ʈ�� ��Ʈ �� ����϶�, ����� ������ ���� ����Ʈ�� ��Ʈ�� ����� �ϰ�, ����Ʈ�� ��Ʈ�� ������ ���� ����ũ�� ����� �մϴ�.

�� ������ ���� �ٸ� ��ų(���� ��)�� ������ ������� ��� �� �ֽ��ϴ�. ���� ����ũ �� ���� �� ����Ʈ�� ��Ʈ �� ����� ���� ��ųƮ���� ����������, ��� �� ����ũ�� ����Ʈ�� ��Ʈ �� ����ũ �� ���� �� ����� ���� ��ųƮ���� �Ұ����մϴ�.

���� ��ų ���� skill�� �������� ���� ��ųƮ��1�� ���� �迭 skill_trees�� �Ű������� �־��� ��, ������ ��ųƮ�� ������ return �ϴ� solution �Լ��� �ۼ����ּ���.

���� ����
��ų�� ���ĺ� �빮�ڷ� ǥ���ϸ�, ��� ���ڿ��� ���ĺ� �빮�ڷθ� �̷���� �ֽ��ϴ�.
��ų ������ ��ųƮ���� ���ڿ��� ǥ���մϴ�.
���� ���, C �� B �� D ��� "CBD"�� ǥ���մϴ�
���� ��ų ���� skill�� ���̴� 1 �̻� 26 �����̸�, ��ų�� �ߺ��� �־����� �ʽ��ϴ�.
skill_trees�� ���� 1 �̻� 20 ������ �迭�Դϴ�.
skill_trees�� ���Ҵ� ��ų�� ��Ÿ���� ���ڿ��Դϴ�.
skill_trees�� ���Ҵ� ���̰� 2 �̻� 26 ������ ���ڿ��̸�, ��ų�� �ߺ��� �־����� �ʽ��ϴ�.
����� ��
skill	skill_trees	return
"CBD"	["BACDE", "CBADF", "AECB", "BDA"]	2
����� �� ����
"BACDE": B ��ų�� ���� ���� C ��ų�� ���� ����� �մϴ�. �Ұ����� ��ųƮ���ϴ�.
"CBADF": ������ ��ųƮ���Դϴ�.
"AECB": ������ ��ųƮ���Դϴ�.
"BDA": B ��ų�� ���� ���� C ��ų�� ���� ����� �մϴ�. �Ұ����� ��ųƮ���Դϴ�.

�´°� ã�°ͺ��� Ʋ���� ã�Ƽ� ���°ŷ�

Ʋ�ȴ� ��: ó�� ������ skill���� ��Ҿ���. skill�� �������� skill_trees�� ���ҵ��� Ȯ���ϸ� 
Ʋ���� �� �� ����!! 
�츮�� Ȯ���ؾ��� �� skill_trees�� ������ ���� �ϳ��ϳ���. 
*
*/
import java.util.Arrays;

class Solution0228_03{
	static int solution0228_03(String skill, String[] skill_trees) {
		int answer = 0;
		for(String s: skill_trees) {
			int i=0;//skill_trees�� ������ ���� �ϳ��ϳ��� �ε��� ����Ű�� ����
			int j=0; //skill�� �ε��� ����Ű�� ����		
			
			while((i == s.length() || j == skill.length()) == false) {
				if(i == s.length() || j == skill.length() == true)break;
				/*i == s.length()�� ��ų ������ �� �� ��
				 * j==skill.length()�� skill���� ���������� �ִ°� �ǹ�
				*/
				if(skill.contains(s.substring(i, i+1)) == true) { // skill�� s.charAt(i)�� �ִٸ�
					if(skill.indexOf(s.charAt(i)) > j) {answer ++; //Ʋ��������������
					
					break;//�� �� �ʿ� ����. ���� s�� �Ѿ��
					}
					else {
						i++; j++;
					}
				}
				else {i++;}//�ش� ���ڿ��� skill�� ���� ��� ���� ���ڿ��� �̵�
			}
			}
		return skill_trees.length -answer;
		}
}
public class practice0228_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution0228_03 sol = new Solution0228_03();
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(sol.solution0228_03("CBD", skill_trees));
	
	}

}
