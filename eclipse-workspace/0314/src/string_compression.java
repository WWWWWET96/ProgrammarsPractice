import java.util.Collections;
import java.util.HashSet;

/*문제 설명
데이터 처리 전문가가 되고 싶은 "어피치"는 문자열을 압축하는 방법에 대해 공부를 하고 있습니다. 최근에 대량의 데이터 처리를 위한 간단한 비손실 압축 방법에 대해 공부를 하고 있는데, 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 더 짧은 문자열로 줄여서 표현하는 알고리즘을 공부하고 있습니다.
간단한 예로 "aabbaccc"의 경우 "2a2ba3c"(문자가 반복되지 않아 한번만 나타난 경우 1은 생략함)와 같이 표현할 수 있는데, 이러한 방식은 반복되는 문자가 적은 경우 압축률이 낮다는 단점이 있습니다. 예를 들면, "abcabcdede"와 같은 문자열은 전혀 압축되지 않습니다. "어피치"는 이러한 단점을 해결하기 위해 문자열을 1개 이상의 단위로 잘라서 압축하여 더 짧은 문자열로 표현할 수 있는지 방법을 찾아보려고 합니다.

예를 들어, "ababcdcdababcdcd"의 경우 문자를 1개 단위로 자르면 전혀 압축되지 않지만, 2개 단위로 잘라서 압축한다면 "2ab2cd2ab2cd"로 표현할 수 있습니다. 다른 방법으로 8개 단위로 잘라서 압축한다면 "2ababcdcd"로 표현할 수 있으며, 이때가 가장 짧게 압축하여 표현할 수 있는 방법입니다.

다른 예로, "abcabcdede"와 같은 경우, 문자를 2개 단위로 잘라서 압축하면 "abcabc2de"가 되지만, 3개 단위로 자른다면 "2abcdede"가 되어 3개 단위가 가장 짧은 압축 방법이 됩니다. 이때 3개 단위로 자르고 마지막에 남는 문자열은 그대로 붙여주면 됩니다.

압축할 문자열 s가 매개변수로 주어질 때, 위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.

제한사항
s의 길이는 1 이상 1,000 이하입니다.
s는 알파벳 소문자로만 이루어져 있습니다.
입출력 예
s	result
"aabbaccc"	7
"ababcdcdababcdcd"	9
"abcabcdede"	8
"abcabcabcabcdededededede"	14
"xababcdcdababcdcd"	17


*/
public class string_compression {
	static int solution(String s) {
		HashSet<Integer> results = new HashSet<>(); // 중복 제거 위해 hashmap사용. 어차피 최소길이만 보면 되니까
		results.add(s.length());//원래 크기도 넣기
		int answer = 0;
		
		int num = 1; // 문자열 자를 크기
		String before = "";
		String now ="";
		int i=0; // 문자열 인덱스 나타내기 위한 변수
		int count=1; //같은 숫자가 얼만큼 나오는지 보기 위한 변수
		before = s.substring(i,i+num); i=i+num; // before의 초기값
		int length = s.length();
		
		while(num != (s.length()/2)+1) { // num반까지만봐도 ok
			if(num == (s.length()/2)+1) break; // s.length()일때 이미 넣어놨기에 볼 필요 없음
			
			while(i < s.length()) {//i가 다 돌때까지
				if(i >= s.length()) break;
				
				if(s.length()-i <=num) {now = s.substring(i,s.length());
					if(before.equals(now)==true) {
						count++; length = length-(count*num)+num+Integer.toString(count).length(); break; // length길이 조절할때 만약 10a면 +2해야하니까 이거 ㅏ자체를 Integer.toString(count).length로
						}
					}
				else{now = s.substring(i, i+num); } 
				
				if(before.equals(now) == true) {count++; }
				else {
					if(count !=1) {//이 문자 전에 반복되는 문자가 있었다는 것. 그만큼의 count를 빼줘야함
						length = length-(count*num)+num+Integer.toString(count).length();//count:반복되는 문자 갯수 num:반복되는 문자열 1:반복되는 문자열 갯수
						count = 1;//초기화
					}
					}
				before = now; 			
				i = i+num;					
				}
			
			results.add(length); count = 1; num++; i = 0; before=s.substring(i,i+num);
			i = i+num; length = s.length();
			
		}
		answer = Collections.min(results);
		return answer;
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="abcabccc";
		
		System.out.println(solution(s));
	}

}
