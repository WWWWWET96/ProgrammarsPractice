import java.util.ArrayList;

/*문제 설명
점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

제한사항
전체 학생의 수는 2명 이상 30명 이하입니다.
체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
입출력 예
n	lost	reserve	return
5	[2, 4]	[1, 3, 5]	5
5	[2, 4]	[3]	4
3	[3]	[1]	2
입출력 예 설명
예제 #1
1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 학생 5명이 체육수업을 들을 수 있습니다.

예제 #2
3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.
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

-> n의 크기만큼의 배열 모두 1로 초기화, lost배열에 해당하는 인덱스는 0으로
n포문 돌면서 0인 값이 나오면 reserve에 0인 값 i의 i-1이나 i+1이 있는지 확인
있으면 i=1로변경해주고 reserve에서 그 값 삭제'

하나는 비워두고 하기

*/
class Solution0204_03{
	static int solution0204_03(int n, int[] lost, int[] reserve) {
	       int answer = 0;
			int[] n_arr = new int[n]; 
			ArrayList<Integer> reserves = new ArrayList<>(); //중복된 번호 제외한 reserves담을 list
			ArrayList<Integer> losts = new ArrayList<>(); //중복된 번호 제외한 lost담을 list
			for(int i : reserve) {reserves.add(i);}
			for(int i=0; i<n;i++) {n_arr[i] = 1; answer++;} // 모든 값 1로 초기화
			
			for(int i=0; i<lost.length; i++) {
				if(reserves.contains(lost[i]) == true) {//번호 겹치면
					reserves.set(reserves.indexOf(lost[i]),null); // 겹치는 값을 null으로
					} else {losts.add(lost[i]);} //안겹치면 losts에 넣기
			}
			for(int i : losts) {n_arr[i-1] = 0; answer--;}
			for(int i=0; i<n_arr.length; i++) {
				if(n_arr[i] == 0) {
					if(reserves.contains(i)){// 빌려줄 친구가 있으면
	                    /*n_arr에서의 인덱스는 번호-1임. 1번 번호가 없으면 n_arr에서는 0번째 인덱스가 0인 것. 그렇지만 reserves에는 번호 그대로 저장돼있음
	                    따라서 n_arr+1-1, n_arr+1+1이 없는 친구 앞 뒤의 번호를 의미*/
						n_arr[i] = 1; //수업 들을 수 있으니까
						answer++;
						reserves.set(reserves.indexOf(i), null);
						continue;//앞 번호 애가 빌려줬으면 뒷 번호는 볼 필요 없으니까
					}
					else if(reserves.contains(i+2)){//i혹은 i+2니까 else if로 묶은 것
						n_arr[i] = 1; //수업 들을 수 있으니까
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
