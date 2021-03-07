import java.util.ArrayList;

/*문제 설명
트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.

예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
0	[]	[]	[7,4,5,6]
1~2	[]	[7]	[4,5,6]
3	[7]	[4]	[5,6]
4	[7]	[4,5]	[6]
5	[7,4]	[5]	[6]
6~7	[7,4,5]	[6]	[]
8	[7,4,5,6]	[]	[]
따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.

solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

제한 조건
bridge_length는 1 이상 10,000 이하입니다.
weight는 1 이상 10,000 이하입니다.
truck_weights의 길이는 1 이상 10,000 이하입니다.
모든 트럭의 무게는 1 이상 weight 이하입니다.
입출력 예
bridge_length	weight	truck_weights	return
2	10	[7,4,5,6]	8
100	100	[10]	101
100	100	[10,10,10,10,10,10,10,10,10,10]	110

*
*-> 경과시간은 answer을 이용하여 알아보기 순서대로 건너는거니까 인덱스 이용하는 truck_weights배열 그대로 사용하면 될듯
*다리를 건너는 트럭을 arraylist 하나 만들기 -> 인덱스 중요하고, 삽입, 삭제 해야하니까
*대기 트럭 배열 길이가 0이되면 다 돈 거
*
*내가 여기서 0번째를 뽑아 쓰고싶은데 굳이 arraylist하는 것보다 큐 이용할것!!
*
*
*/

class Solution0211_02{
	public static int solution0211_02(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		ArrayList<Integer> truck_weight = new ArrayList<>();//건너야 할 트럭들
		for(int i:truck_weights) {truck_weight.add(i);}
		
		ArrayList<Integer> ing_truck = new ArrayList<>(); //건너고 있는 트럭들
		ArrayList<Integer> time_count = new ArrayList<>();//건너고 있는 트럭들의 경과시간
		int ing_weight=0; // 건너고있는 트럭들의 총 무게 ing_weigth <= weigth여야함 
		bridge_length = bridge_length+1; //+1해야 다리 다 건넌거
		
		while(truck_weight.size() != 0 || ing_weight >= 0) {//둘 중 하나라도 값이 있으면 건너고 있는, 혹은 건너야할 트럭이 있다는 말이니까
			answer++; // 시간 증가는 먼저 일어나야 함
			if(time_count.size() != 0) { // 인덱스넣어 값 뽑는거니까 0이면 안된다는 전제조건 있어야함
				for(int idx=0; idx<time_count.size(); idx++) {time_count.set(idx, time_count.get(idx)+1);} // 1초씩 증가
				
				if(time_count.get(0) == bridge_length) { // 다 건넌거니까
					ing_weight = ing_weight - ing_truck.get(0);//다리에 있는 트럭들의 무게에서 다 건넌 트럭의 무게 빼주기
					ing_truck.remove(0); time_count.remove(0); //건너고 있는 트럭과 그 경과시간을 나타내는 리스트들에서도 삭제해줘야함
					if(truck_weight.size() ==0 && time_count.size() ==0) return answer; // 이거안해줬더니 무한루프 돌았음 질문하기
			}
				}
			if(truck_weight.size() !=0) {
				if((ing_weight + truck_weight.get(0)) <= weight) { //그 다음 트럭의 무게를 더했을 때 weight보다 작다면 건널 수 있음
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
