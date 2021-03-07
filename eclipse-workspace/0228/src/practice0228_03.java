/*문제 설명
선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.

예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.

위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.

선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.

제한 조건
스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
스킬 순서와 스킬트리는 문자열로 표기합니다.
예를 들어, C → B → D 라면 "CBD"로 표기합니다
선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
skill_trees는 길이 1 이상 20 이하인 배열입니다.
skill_trees의 원소는 스킬을 나타내는 문자열입니다.
skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.
입출력 예
skill	skill_trees	return
"CBD"	["BACDE", "CBADF", "AECB", "BDA"]	2
입출력 예 설명
"BACDE": B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트립니다.
"CBADF": 가능한 스킬트리입니다.
"AECB": 가능한 스킬트리입니다.
"BDA": B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.

맞는걸 찾는것보다 틀린걸 찾아서 빼는거로

틀렸던 점: 처음 기준을 skill에서 잡았었음. skill을 기준으로 skill_trees의 원소들을 확인하면 
틀린지 알 수 없음!! 
우리가 확인해야할 건 skill_trees의 원소의 글자 하나하나임. 
*
*/
import java.util.Arrays;

class Solution0228_03{
	static int solution0228_03(String skill, String[] skill_trees) {
		int answer = 0;
		for(String s: skill_trees) {
			int i=0;//skill_trees의 원소의 문자 하나하나의 인덱스 가리키는 변수
			int j=0; //skill의 인덱스 가리키는 변수		
			
			while((i == s.length() || j == skill.length()) == false) {
				if(i == s.length() || j == skill.length() == true)break;
				/*i == s.length()는 스킬 순서를 다 본 것
				 * j==skill.length()는 skill들이 선행순서대로 있는걸 의미
				*/
				if(skill.contains(s.substring(i, i+1)) == true) { // skill에 s.charAt(i)가 있다면
					if(skill.indexOf(s.charAt(i)) > j) {answer ++; //틀린갯수세기위해
					
					break;//더 볼 필요 없음. 다음 s로 넘어가기
					}
					else {
						i++; j++;
					}
				}
				else {i++;}//해당 문자열이 skill에 없는 경우 다음 문자열로 이동
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
