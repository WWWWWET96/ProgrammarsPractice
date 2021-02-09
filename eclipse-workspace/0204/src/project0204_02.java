import java.util.Set;
import java.util.TreeSet;

/*문제 설명
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
입출력 예
numbers	return
17	3
011	2
입출력 예 설명
예제 #1
[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

예제 #2
[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.

11과 011은 같은 숫자로 취급합니다.

2가지의 기능-> 1.만들 수 있는 모든 숫자 조합 만드는 기능: 순열 이용 -> n개의 원소 중 r개의 원소 꺼내는 경우의 수/ 순서유효
순열에서 {1,2,3}과 {1,3,2}와 {2,1,3}은 모두 다른 것

https://minhamina.tistory.com/37

depth가 result의 인덱스를 결정한다고 생각?
 2.소수 검사하는 기능
 (‘1’,)
(‘1’,’2’)
Set<Integer> TreeNums = new TreeSet<>();
011 11
“011” -> 11

 
 treeset-> 쓰는건 hashset처럼 사용. 대신 이진트리라 검색값이 더 빠름
*/
public class project0204_02  {
	static Set<Integer> TreeNums = new TreeSet<>(); //set은 중복 값 넣을 수 없음. treeset은 검색 더 원활
	public static void permutations(String str, String nums, int depth) {

		if(str.length() == depth) // 끝까지 다 돈거
		{
			TreeNums.add(Integer.parseInt(str));
		}
	else {
		TreeNums.add(Integer.parseInt(str)); 
		/*우리는 3개중 3개를 뽑은 순열만 보는게 아니라 3개중 1개뽑았을 때, 2개~도 봐야함
		 * 그렇기 때문에 뽑았던 모든 조합들 다 TreeNums에 넣어야하니까 else일때도 TreeNums에 삽입해야하는것
		 * 여기서 정말 중요한건 SET을 썼다는 것임
		 * set을 안쓰고 그냥 배열 등에 저장하면 011, 11을 다른 숫자로 봤을 것임!!
		 * 그리고 만약 string이였어도 "011"과 "11"은 다른 것으로 봤을거임 
		 * 그렇기에 여기서 integer로 바꿨다는 건 매우 중요!!!!!*/
		for(int i =0; i<nums.length();i++) {
			permutations(str+nums.charAt(i), nums.substring(0, i)+
					nums.substring(i+1, nums.length()), depth+1);
		}
	}
		}
	
	
	public static int solution0204_02(String numbers) {
		int answer = 0;
		String[] nums = numbers.split(""); 
		int n = numbers.length();
		
		for(int i = 0; i<n; i++) {
			permutations(""+numbers.charAt(i), numbers.substring(0, i)+
					numbers.substring(i+1, n), n);
		}
		
		for(int i:TreeNums) {
			if(i !=2 && (i&1) == 0) continue;
			int div = 3; int value = i;
			int sqrtNums = (int)Math.sqrt(i);
			while(sqrtNums >= div) {
				if(i % div == 0) {value = 1; break;}
				div += 1;
				
			}
			answer += (value ==1)?0:1; //삼항연산자 사용. value가 1이면(소수가 아니면) 0, 1이아니면 1
		}
		return answer;
	}
	public static void main(String[] args) {
		String numbers = "011";

		System.out.println(solution0204_02(numbers));
	}
		
		
		
	}

