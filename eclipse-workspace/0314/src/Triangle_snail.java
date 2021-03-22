import java.util.Arrays;

/*���� ����-�ﰢ ������
 * https://programmers.co.kr/learn/courses/30/lessons/68645
 * 
���� n�� �Ű������� �־����ϴ�. 
���� �׸��� ���� �غ��� ���̿� ���̰� n�� �ﰢ������ �� �� ���������� �ݽð� �������� ������ ä��⸦ ������ ��,
 ù ����� ������ ����� ��� ������� ��ģ ���ο� �迭�� return �ϵ��� solution �Լ��� �ϼ����ּ���.

���ѻ���
n�� 1 �̻� 1,000 �����Դϴ�.
����� ��
n	result
4	[1,2,9,3,10,8,4,5,6,7]
5	[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
6	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]

n=4, 10
n=5 10+5
n =6 
//�迭�� ����
n�̸� 1+2+3+...+n 

//�迭�� �� ������ ������� ��µ�! ���� ��� �������ص� OK
*/
public class Triangle_snail {
	static int[] solution(int n) {
		int[] answer = {}; // �ε��� �̿��ؼ� ����ҰŴϱ� �迭 �״�� �̿��ϱ�
		int size =0;
		for(int num=1; num<=n; num++) {size = size+num;} // �迭 ������ ���ϱ�	
		answer = new int[size];
		
		int plus = 0; // �밢������ ���� �ε����� �Ѿ �� ���̴� ���� plus=1 ~ (n-1)
		int num = 1; // 1~size���� �ִ� ����
		int idx=0;// �ﰢ�� �۾����鼭 n �ٲ����� 
		int idx_new_startpt=0; // �ﰢ���� �۾��� �� �ٽ� ���۵� �ε��� idx ��ȭ? 0,4,12,24...(4,8,12...�� ������)
		int count=1;//idx_new_startpt �ε��� ������ �� ���� count
		
		while(num != size+1) {
			if(num == size+1) break;
			
			for(int i=0; i<n; i++) { // ���� �밢��
				answer[idx] = num; 
				num++; plus++;
				if(i==(n-1)) continue;
				idx = idx+plus;//���� �밢���� ���� idx+(1,2,3,4,5...)������ �ٲ� -> 0,1,3(1+2),6(1+2+3), 10(1+2+3+4)...
				//�̶� ���ϴ� ���� plus �� ��
			}
			
			idx++; // �� ĭ ������ ������
			
			for(int i=0; i<n-1; i++) { // �� ������ ��.���� �밢������ �ϳ� �־����ϱ� i�� n-1����
				answer[idx]=num; num++; 
				if(i == (n-2)) continue;
				idx++;//�ﰢ�� �غκ��� idx�״�� ����
			}
			idx = idx-plus; //������ �밢���� ���������� �������� plus��ŭ ���� ��
			//���� �밢���� plus�� 1,2,3,4,5...������ �þ���� ������ �밢���� ���ʺ��� �ϳ� �� ������ ���¿��� ����, ���� �ϳ� �� ����(���ʿ��� �̹� ó���ѰŴϱ�)

			for(int i=0; i<n-2; i++) { //����, �� �밢������ ó���Ѱ� �����ϱ� n-2
				answer[idx] = num;num++; plus--;
				idx = idx-plus;	//���⼱ �������� if������ ó�������൵ ��. �ؿ��� ���� �ﰢ������ �������� idx�� ���� �����ϴϱ�		
			}
			idx_new_startpt= idx_new_startpt +(4*count);
			idx = idx_new_startpt;count++;
			n = n-3;//���� �ﰢ���� ū �ﰢ���� 3ĭ�� ���̰� ���ϱ�(�� �� ��ĭ, �� �Ʒ� �� ĭ)			
		}
			
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=7;
		System.out.println(Arrays.toString(solution(n)));
	}

}
