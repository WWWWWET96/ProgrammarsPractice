import java.util.Arrays;

/*���� ����
�Լ� solution�� ���� x�� �ڿ��� n�� �Է� �޾�, x���� ������ x�� �����ϴ� ���ڸ� n�� ���ϴ� ����Ʈ�� �����ؾ� �մϴ�. ���� ���� ������ ����, ������ �����ϴ� �Լ�, solution�� �ϼ����ּ���.

���� ����
x�� -10000000 �̻�, 10000000 ������ �����Դϴ�.
n�� 1000 ������ �ڿ����Դϴ�.
����� ��
x	n	answer
2	5	[2,4,6,8,10]
4	3	[4,8,12]
-4	2	[-4, -8]

*longŸ������ ��ȯ�ϴµ� ����� �� x�� int�ϱ� �̰͵� long���� ��������ȯ ���������
*/


class Solution0211 {
    public static long[] solution0211(int x, int n) {
        long[] answer = {};
        if(x>10000000 || x<-10000000 || (n>1000)) return answer;
		answer = new long[n];
       int i=0;	while(i!=n) {answer[i]=((long)x*i)+(long)x; i++; }
	
        return answer;
    }
}
public class practice0211 extends Solution0211{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x =2; int n=5;
	
	System.out.println(Arrays.toString(solution0211(x,n)));
	}

}
