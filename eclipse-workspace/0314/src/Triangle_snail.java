import java.util.Arrays;

/*문제 설명-삼각 달팽이
 * https://programmers.co.kr/learn/courses/30/lessons/68645
 * 
정수 n이 매개변수로 주어집니다. 
다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후,
 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 1 이상 1,000 이하입니다.
입출력 예
n	result
4	[1,2,9,3,10,8,4,5,6,7]
5	[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
6	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]

n=4, 10
n=5 10+5
n =6 
//배열의 갯수
n이면 1+2+3+...+n 

//배열에 값 넣으면 순서대로 출력됨! 굳이 출력 생각안해도 OK
*/
public class Triangle_snail {
	static int[] solution(int n) {
		int[] answer = {}; // 인덱스 이용해서 출력할거니까 배열 그대로 이용하기
		int size =0;
		for(int num=1; num<=n; num++) {size = size+num;} // 배열 사이즈 구하기	
		answer = new int[size];
		
		int plus = 0; // 대각선에서 다음 인덱스로 넘어갈 때 쓰이는 변수 plus=1 ~ (n-1)
		int num = 1; // 1~size까지 넣는 숫자
		int idx=0;// 삼각형 작아지면서 n 바뀌어야함 
		int idx_new_startpt=0; // 삼각형이 작아질 때 다시 시작될 인덱스 idx 변화? 0,4,12,24...(4,8,12...의 차이임)
		int count=1;//idx_new_startpt 인덱스 변경할 때 쓰일 count
		
		while(num != size+1) {
			if(num == size+1) break;
			
			for(int i=0; i<n; i++) { // 왼쪽 대각선
				answer[idx] = num; 
				num++; plus++;
				if(i==(n-1)) continue;
				idx = idx+plus;//왼쪽 대각선은 기존 idx+(1,2,3,4,5...)순으로 바뀜 -> 0,1,3(1+2),6(1+2+3), 10(1+2+3+4)...
				//이때 더하는 수가 plus 인 것
			}
			
			idx++; // 한 칸 앞으로 가야함
			
			for(int i=0; i<n-1; i++) { // 맨 마지막 줄.왼쪽 대각선에서 하나 넣었으니까 i는 n-1까지
				answer[idx]=num; num++; 
				if(i == (n-2)) continue;
				idx++;//삼각형 밑부분은 idx그대로 증가
			}
			idx = idx-plus; //오른쪽 대각선의 시작점으로 가기위해 plus만큼 빼는 것
			//왼쪽 대각선은 plus가 1,2,3,4,5...순으로 늘어나지만 오른쪽 대각선은 왼쪽보다 하나 더 증가한 상태에서 감소, 갯수 하나 더 적음(왼쪽에서 이미 처리한거니까)

			for(int i=0; i<n-2; i++) { //왼쪽, 밑 대각선에서 처리한게 있으니까 n-2
				answer[idx] = num;num++; plus--;
				idx = idx-plus;	//여기선 마지막꺼 if문으로 처리안해줘도 됨. 밑에서 작은 삼각형으로 가기위해 idx값 새로 대입하니까		
			}
			idx_new_startpt= idx_new_startpt +(4*count);
			idx = idx_new_startpt;count++;
			n = n-3;//작은 삼각형은 큰 삼각형과 3칸의 차이가 나니까(맨 위 두칸, 맨 아래 한 칸)			
		}
			
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=7;
		System.out.println(Arrays.toString(solution(n)));
	}

}
