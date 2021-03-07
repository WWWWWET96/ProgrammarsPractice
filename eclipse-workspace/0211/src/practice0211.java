import java.util.Arrays;

/*문제 설명
함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

제한 조건
x는 -10000000 이상, 10000000 이하인 정수입니다.
n은 1000 이하인 자연수입니다.
입출력 예
x	n	answer
2	5	[2,4,6,8,10]
4	3	[4,8,12]
-4	2	[-4, -8]

*long타입으로 반환하는데 계산할 때 x가 int니까 이것도 long으로 강제형변환 시켜줘야함
*/


class Solution0211 {
    public static long[] solution0211(int x, int n) {
        long[] answer = {};
        if(x>10000000 || x<-10000000 || (n>1000)) return answer;
		answer = new long[n];
       int i=0;	while(i!=n) {answer[i]=((long)x*i)+(long)x; i++; }
	
        return answer;
    }
}
public class practice0211 extends Solution0211{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x =2; int n=5;
	
	System.out.println(Arrays.toString(solution0211(x,n)));
	}

}
