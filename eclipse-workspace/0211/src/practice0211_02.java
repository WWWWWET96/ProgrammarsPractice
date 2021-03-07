import java.util.ArrayList;

/*���� ����
Ʈ�� ���� �밡 ���� ���������� �� ���� �ٸ��� ������ ������ �ǳʷ� �մϴ�. ��� Ʈ���� �ٸ��� �ǳʷ��� �ּ� �� �ʰ� �ɸ����� �˾Ƴ��� �մϴ�. Ʈ���� 1�ʿ� 1��ŭ �����̸�, �ٸ� ���̴� bridge_length�̰� �ٸ��� ���� weight���� �ߵ��ϴ�.
�� Ʈ���� �ٸ��� ������ ������ ���� ���, �� Ʈ���� ���Դ� ������� �ʽ��ϴ�.

���� ���, ���̰� 2�̰� 10kg ���Ը� �ߵ�� �ٸ��� �ֽ��ϴ�. ���԰� [7, 4, 5, 6]kg�� Ʈ���� ������� �ִ� �ð� �ȿ� �ٸ��� �ǳʷ��� ������ ���� �ǳʾ� �մϴ�.

��� �ð�	�ٸ��� ���� Ʈ��	�ٸ��� �ǳʴ� Ʈ��	��� Ʈ��
0	[]	[]	[7,4,5,6]
1~2	[]	[7]	[4,5,6]
3	[7]	[4]	[5,6]
4	[7]	[4,5]	[6]
5	[7,4]	[5]	[6]
6~7	[7,4,5]	[6]	[]
8	[7,4,5,6]	[]	[]
����, ��� Ʈ���� �ٸ��� �������� �ּ� 8�ʰ� �ɸ��ϴ�.

solution �Լ��� �Ű������� �ٸ� ���� bridge_length, �ٸ��� �ߵ� �� �ִ� ���� weight, Ʈ���� ���� truck_weights�� �־����ϴ�. �̶� ��� Ʈ���� �ٸ��� �ǳʷ��� �ּ� �� �ʰ� �ɸ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.

���� ����
bridge_length�� 1 �̻� 10,000 �����Դϴ�.
weight�� 1 �̻� 10,000 �����Դϴ�.
truck_weights�� ���̴� 1 �̻� 10,000 �����Դϴ�.
��� Ʈ���� ���Դ� 1 �̻� weight �����Դϴ�.
����� ��
bridge_length	weight	truck_weights	return
2	10	[7,4,5,6]	8
100	100	[10]	101
100	100	[10,10,10,10,10,10,10,10,10,10]	110

*
*-> ����ð��� answer�� �̿��Ͽ� �˾ƺ��� ������� �ǳʴ°Ŵϱ� �ε��� �̿��ϴ� truck_weights�迭 �״�� ����ϸ� �ɵ�
*�ٸ��� �ǳʴ� Ʈ���� arraylist �ϳ� ����� -> �ε��� �߿��ϰ�, ����, ���� �ؾ��ϴϱ�
*��� Ʈ�� �迭 ���̰� 0�̵Ǹ� �� �� ��
*
*���� ���⼭ 0��°�� �̾� ��������� ���� arraylist�ϴ� �ͺ��� ť �̿��Ұ�!!
*
*
*/

class Solution0211_02{
	public static int solution0211_02(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		ArrayList<Integer> truck_weight = new ArrayList<>();//�ǳʾ� �� Ʈ����
		for(int i:truck_weights) {truck_weight.add(i);}
		
		ArrayList<Integer> ing_truck = new ArrayList<>(); //�ǳʰ� �ִ� Ʈ����
		ArrayList<Integer> time_count = new ArrayList<>();//�ǳʰ� �ִ� Ʈ������ ����ð�
		int ing_weight=0; // �ǳʰ��ִ� Ʈ������ �� ���� ing_weigth <= weigth������ 
		bridge_length = bridge_length+1; //+1�ؾ� �ٸ� �� �ǳͰ�
		
		while(truck_weight.size() != 0 || ing_weight >= 0) {//�� �� �ϳ��� ���� ������ �ǳʰ� �ִ�, Ȥ�� �ǳʾ��� Ʈ���� �ִٴ� ���̴ϱ�
			answer++; // �ð� ������ ���� �Ͼ�� ��
			if(time_count.size() != 0) { // �ε����־� �� �̴°Ŵϱ� 0�̸� �ȵȴٴ� �������� �־����
				for(int idx=0; idx<time_count.size(); idx++) {time_count.set(idx, time_count.get(idx)+1);} // 1�ʾ� ����
				
				if(time_count.get(0) == bridge_length) { // �� �ǳͰŴϱ�
					ing_weight = ing_weight - ing_truck.get(0);//�ٸ��� �ִ� Ʈ������ ���Կ��� �� �ǳ� Ʈ���� ���� ���ֱ�
					ing_truck.remove(0); time_count.remove(0); //�ǳʰ� �ִ� Ʈ���� �� ����ð��� ��Ÿ���� ����Ʈ�鿡���� �����������
					if(truck_weight.size() ==0 && time_count.size() ==0) return answer; // �̰ž�������� ���ѷ��� ������ �����ϱ�
			}
				}
			if(truck_weight.size() !=0) {
				if((ing_weight + truck_weight.get(0)) <= weight) { //�� ���� Ʈ���� ���Ը� ������ �� weight���� �۴ٸ� �ǳ� �� ����
					ing_weight = ing_weight + truck_weight.get(0);
				time_count.add(1); ing_truck.add(truck_weight.get(0));
				truck_weight.remove(0);
				}
			}
		}	
		
		return answer;
	
}
}
public class practice0211_02 extends Solution0211_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		
		System.out.println(solution0211_02(bridge_length, weight, truck_weights));
	}

}
