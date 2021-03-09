/*https://programmers.co.kr/learn/courses/30/lessons/72410
 * 
 * -> 정규표현식 쓸 수 있나 물어보는 문제
 * 
 **** ^로 시작하면 이거 이외의 것들은 다~ 의미하는 것
 * [^a-z0-9-_.] -> a-z까지, 0-9까지, -_. 세개 전부가 ^아닌 것들을 replace해라
 * [.]{2,}는 .으로 시작하는 것 중 {2,}이상인 것
 * 
 * -> 특수기호는 앞에 []나 \\붙이는 거 잊지말기!!
 * 
 * 주의해야할 것 substring시 endindex전까지 출력하는거 잊지말기!!
 * 
 * 
 * */

public class New_ID {
	static String solution(String new_id) {

		new_id = new_id.toLowerCase(); // 1단계: 모든 대문자를 소문자로 치환
		StringBuilder changing;// 문자변경을 위한 StringBuilder 생성
		
		new_id=new_id.replaceAll("[^a-z0-9-_.]", ""); //2단계
		
		//new_id = new_id.replaceAll(".{2,}", "."); -> .하나 출력됨 .뒤에 모든 것들 다 .로 치환하라는걸로 아나봄
		new_id = new_id.replaceAll("[.]{2,}", "."); //3단계

		if(new_id.startsWith(".")) new_id=new_id.substring(1);
		if(new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length()-1);
		//4단계

		if(new_id.isBlank()) new_id = "a"; //5단계
		
		if(new_id.length() >=16)new_id = new_id.substring(0, 15);
		if(new_id.endsWith(".")) new_id = new_id.substring(0,new_id.length()-1);
		//6단계
		
		changing = new StringBuilder(new_id);
		while(changing.length() <3) {
			char c = new_id.charAt(new_id.length()-1);
			changing.append(c);
		}
		new_id = changing.toString();
		
		return new_id;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
	} 

}
