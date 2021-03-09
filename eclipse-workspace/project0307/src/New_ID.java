/*https://programmers.co.kr/learn/courses/30/lessons/72410
 * 
 * -> ����ǥ���� �� �� �ֳ� ����� ����
 * 
 **** ^�� �����ϸ� �̰� �̿��� �͵��� ��~ �ǹ��ϴ� ��
 * [^a-z0-9-_.] -> a-z����, 0-9����, -_. ���� ���ΰ� ^�ƴ� �͵��� replace�ض�
 * [.]{2,}�� .���� �����ϴ� �� �� {2,}�̻��� ��
 * 
 * -> Ư����ȣ�� �տ� []�� \\���̴� �� ��������!!
 * 
 * �����ؾ��� �� substring�� endindex������ ����ϴ°� ��������!!
 * 
 * 
 * */

public class New_ID {
	static String solution(String new_id) {

		new_id = new_id.toLowerCase(); // 1�ܰ�: ��� �빮�ڸ� �ҹ��ڷ� ġȯ
		StringBuilder changing;// ���ں����� ���� StringBuilder ����
		
		new_id=new_id.replaceAll("[^a-z0-9-_.]", ""); //2�ܰ�
		
		//new_id = new_id.replaceAll(".{2,}", "."); -> .�ϳ� ��µ� .�ڿ� ��� �͵� �� .�� ġȯ�϶�°ɷ� �Ƴ���
		new_id = new_id.replaceAll("[.]{2,}", "."); //3�ܰ�

		if(new_id.startsWith(".")) new_id=new_id.substring(1);
		if(new_id.endsWith(".")) new_id = new_id.substring(0, new_id.length()-1);
		//4�ܰ�

		if(new_id.isBlank()) new_id = "a"; //5�ܰ�
		
		if(new_id.length() >=16)new_id = new_id.substring(0, 15);
		if(new_id.endsWith(".")) new_id = new_id.substring(0,new_id.length()-1);
		//6�ܰ�
		
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
