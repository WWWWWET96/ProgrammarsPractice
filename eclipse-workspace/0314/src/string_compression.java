import java.util.Collections;
import java.util.HashSet;

/*���� ����
������ ó�� �������� �ǰ� ���� "����ġ"�� ���ڿ��� �����ϴ� ����� ���� ���θ� �ϰ� �ֽ��ϴ�. �ֱٿ� �뷮�� ������ ó���� ���� ������ ��ս� ���� ����� ���� ���θ� �ϰ� �ִµ�, ���ڿ����� ���� ���� �����ؼ� ��Ÿ���� ���� �� ������ ������ �ݺ��Ǵ� ������ ǥ���Ͽ� �� ª�� ���ڿ��� �ٿ��� ǥ���ϴ� �˰����� �����ϰ� �ֽ��ϴ�.
������ ���� "aabbaccc"�� ��� "2a2ba3c"(���ڰ� �ݺ����� �ʾ� �ѹ��� ��Ÿ�� ��� 1�� ������)�� ���� ǥ���� �� �ִµ�, �̷��� ����� �ݺ��Ǵ� ���ڰ� ���� ��� ������� ���ٴ� ������ �ֽ��ϴ�. ���� ���, "abcabcdede"�� ���� ���ڿ��� ���� ������� �ʽ��ϴ�. "����ġ"�� �̷��� ������ �ذ��ϱ� ���� ���ڿ��� 1�� �̻��� ������ �߶� �����Ͽ� �� ª�� ���ڿ��� ǥ���� �� �ִ��� ����� ã�ƺ����� �մϴ�.

���� ���, "ababcdcdababcdcd"�� ��� ���ڸ� 1�� ������ �ڸ��� ���� ������� ������, 2�� ������ �߶� �����Ѵٸ� "2ab2cd2ab2cd"�� ǥ���� �� �ֽ��ϴ�. �ٸ� ������� 8�� ������ �߶� �����Ѵٸ� "2ababcdcd"�� ǥ���� �� ������, �̶��� ���� ª�� �����Ͽ� ǥ���� �� �ִ� ����Դϴ�.

�ٸ� ����, "abcabcdede"�� ���� ���, ���ڸ� 2�� ������ �߶� �����ϸ� "abcabc2de"�� ������, 3�� ������ �ڸ��ٸ� "2abcdede"�� �Ǿ� 3�� ������ ���� ª�� ���� ����� �˴ϴ�. �̶� 3�� ������ �ڸ��� �������� ���� ���ڿ��� �״�� �ٿ��ָ� �˴ϴ�.

������ ���ڿ� s�� �Ű������� �־��� ��, ���� ������ ������� 1�� �̻� ������ ���ڿ��� �߶� �����Ͽ� ǥ���� ���ڿ� �� ���� ª�� ���� ���̸� return �ϵ��� solution �Լ��� �ϼ����ּ���.

���ѻ���
s�� ���̴� 1 �̻� 1,000 �����Դϴ�.
s�� ���ĺ� �ҹ��ڷθ� �̷���� �ֽ��ϴ�.
����� ��
s	result
"aabbaccc"	7
"ababcdcdababcdcd"	9
"abcabcdede"	8
"abcabcabcabcdededededede"	14
"xababcdcdababcdcd"	17


*/
public class string_compression {
	static int solution(String s) {
		HashSet<Integer> results = new HashSet<>(); // �ߺ� ���� ���� hashmap���. ������ �ּұ��̸� ���� �Ǵϱ�
		results.add(s.length());//���� ũ�⵵ �ֱ�
		int answer = 0;
		
		int num = 1; // ���ڿ� �ڸ� ũ��
		String before = "";
		String now ="";
		int i=0; // ���ڿ� �ε��� ��Ÿ���� ���� ����
		int count=1; //���� ���ڰ� ��ŭ �������� ���� ���� ����
		before = s.substring(i,i+num); i=i+num; // before�� �ʱⰪ
		int length = s.length();
		
		while(num != (s.length()/2)+1) { // num�ݱ��������� ok
			if(num == (s.length()/2)+1) break; // s.length()�϶� �̹� �־���⿡ �� �ʿ� ����
			
			while(i < s.length()) {//i�� �� ��������
				if(i >= s.length()) break;
				
				if(s.length()-i <=num) {now = s.substring(i,s.length());
					if(before.equals(now)==true) {
						count++; length = length-(count*num)+num+Integer.toString(count).length(); break; // length���� �����Ҷ� ���� 10a�� +2�ؾ��ϴϱ� �̰� ����ü�� Integer.toString(count).length��
						}
					}
				else{now = s.substring(i, i+num); } 
				
				if(before.equals(now) == true) {count++; }
				else {
					if(count !=1) {//�� ���� ���� �ݺ��Ǵ� ���ڰ� �־��ٴ� ��. �׸�ŭ�� count�� �������
						length = length-(count*num)+num+Integer.toString(count).length();//count:�ݺ��Ǵ� ���� ���� num:�ݺ��Ǵ� ���ڿ� 1:�ݺ��Ǵ� ���ڿ� ����
						count = 1;//�ʱ�ȭ
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
