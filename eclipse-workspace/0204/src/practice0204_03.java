import java.util.ArrayList;

/*���� ����
���ɽð��� ������ ���, �Ϻ� �л��� ü������ �������߽��ϴ�. ������ ���� ü������ �ִ� �л��� �̵鿡�� ü������ �����ַ� �մϴ�. �л����� ��ȣ�� ü�� ������ �Ű��� �־�, �ٷ� �չ�ȣ�� �л��̳� �ٷ� �޹�ȣ�� �л����Ը� ü������ ������ �� �ֽ��ϴ�. ���� ���, 4�� �л��� 3�� �л��̳� 5�� �л����Ը� ü������ ������ �� �ֽ��ϴ�. ü������ ������ ������ ���� �� ���� ������ ü������ ������ ���� �ִ��� ���� �л��� ü�������� ���� �մϴ�.

��ü �л��� �� n, ü������ �������� �л����� ��ȣ�� ��� �迭 lost, ������ ü������ ������ �л����� ��ȣ�� ��� �迭 reserve�� �Ű������� �־��� ��, ü�������� ���� �� �ִ� �л��� �ִ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
��ü �л��� ���� 2�� �̻� 30�� �����Դϴ�.
ü������ �������� �л��� ���� 1�� �̻� n�� �����̰� �ߺ��Ǵ� ��ȣ�� �����ϴ�.
������ ü������ ������ �л��� ���� 1�� �̻� n�� �����̰� �ߺ��Ǵ� ��ȣ�� �����ϴ�.
���� ü������ �ִ� �л��� �ٸ� �л����� ü������ ������ �� �ֽ��ϴ�.
���� ü������ ������ �л��� ü������ ���������� �� �ֽ��ϴ�. �̶� �� �л��� ü������ �ϳ��� �������ߴٰ� �����ϸ�, ���� ü������ �ϳ��̱⿡ �ٸ� �л����Դ� ü������ ������ �� �����ϴ�.
����� ��
n	lost	reserve	return
5	[2, 4]	[1, 3, 5]	5
5	[2, 4]	[3]	4
3	[3]	[1]	2
����� �� ����
���� #1
1�� �л��� 2�� �л����� ü������ �����ְ�, 3�� �л��̳� 5�� �л��� 4�� �л����� ü������ �����ָ� �л� 5���� ü�������� ���� �� �ֽ��ϴ�.

���� #2
3�� �л��� 2�� �л��̳� 4�� �л����� ü������ �����ָ� �л� 4���� ü�������� ���� �� �ֽ��ϴ�.
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lost_list = new ArrayList<>();
        List<Integer> reserve_list = Arrays.stream(reserve).boxed().collect(Collectors.toList());

        for(int i: lost){
            if(reserve_list.contains(i)){
                reserve_list.remove(Integer.valueOf(i));
                continue;
            }
            lost_list.add(i);
        }

        for(int l:lost_list){
            if(reserve_list.contains(l-1)){

                reserve_list.remove(Integer.valueOf(l - 1));
                continue;
            }
            if(reserve_list.contains(l+1)){
                reserve_list.remove(Integer.valueOf(l + 1));
                continue;
            }
            n--;

        }
        return n;
    }
}

-> n�� ũ�⸸ŭ�� �迭 ��� 1�� �ʱ�ȭ, lost�迭�� �ش��ϴ� �ε����� 0����
n���� ���鼭 0�� ���� ������ reserve�� 0�� �� i�� i-1�̳� i+1�� �ִ��� Ȯ��
������ i=1�κ������ְ� reserve���� �� �� ����'

�ϳ��� ����ΰ� �ϱ�

*/
class Solution0204_03{
	static int solution0204_03(int n, int[] lost, int[] reserve) {
	       int answer = 0;
			int[] n_arr = new int[n]; 
			ArrayList<Integer> reserves = new ArrayList<>(); //�ߺ��� ��ȣ ������ reserves���� list
			ArrayList<Integer> losts = new ArrayList<>(); //�ߺ��� ��ȣ ������ lost���� list
			for(int i : reserve) {reserves.add(i);}
			for(int i=0; i<n;i++) {n_arr[i] = 1; answer++;} // ��� �� 1�� �ʱ�ȭ
			
			for(int i=0; i<lost.length; i++) {
				if(reserves.contains(lost[i]) == true) {//��ȣ ��ġ��
					reserves.set(reserves.indexOf(lost[i]),null); // ��ġ�� ���� null����
					} else {losts.add(lost[i]);} //�Ȱ�ġ�� losts�� �ֱ�
			}
			for(int i : losts) {n_arr[i-1] = 0; answer--;}
			for(int i=0; i<n_arr.length; i++) {
				if(n_arr[i] == 0) {
					if(reserves.contains(i)){// ������ ģ���� ������
	                    /*n_arr������ �ε����� ��ȣ-1��. 1�� ��ȣ�� ������ n_arr������ 0��° �ε����� 0�� ��. �׷����� reserves���� ��ȣ �״�� ���������
	                    ���� n_arr+1-1, n_arr+1+1�� ���� ģ�� �� ���� ��ȣ�� �ǹ�*/
						n_arr[i] = 1; //���� ���� �� �����ϱ�
						answer++;
						reserves.set(reserves.indexOf(i), null);
						continue;//�� ��ȣ �ְ� ���������� �� ��ȣ�� �� �ʿ� �����ϱ�
					}
					else if(reserves.contains(i+2)){//iȤ�� i+2�ϱ� else if�� ���� ��
						n_arr[i] = 1; //���� ���� �� �����ϱ�
						answer++;
						reserves.set(reserves.indexOf(i+2), null);
					}
				}}
			
		 return answer;
	}
}
public class practice0204_03 extends Solution0204_03{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[] lost = {2,4};
		int[] reserve = {2,3};
		
		System.out.println(solution0204_03(n,lost,reserve));
	}

}
