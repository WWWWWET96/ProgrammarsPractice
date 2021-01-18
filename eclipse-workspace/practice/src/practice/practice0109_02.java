package practice;
import java.util.ArrayList;
import java.util.Arrays;
// 배열과 리스트 차이? list는 배열처럼 고정된 크기 가지는 것이 아니라 메모리가 허용하는 한 자동으로 arraylist크기 동적으로 변경
import java.util.Scanner;

/*class Solution0109_02{
	public static int[] solution(int []arr) {
		int[] answer = {}; 
		ArrayList<Integer> templist = new ArrayList<>();
		int size = arr.length;
		for(int a=0; a<size -1; a++) {
			if(arr[a] == arr[a+1])
				continue;
			else 
				templist.add(arr[a]);
		}
		
		if(arr[size-1]== arr[size-2])
			{
			templist.add(arr[size-1]);
			}
		
		answer = new int[templist.size()];
		
		for(int p=0; p<templist.size(); p++) {
			answer[p] = templist.get(p);//값 삽입
		}
		
		
		return answer;
	}
}*/
public class practice0109_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ArrayList<Integer> templist = new ArrayList<>();
		int[] arr = {1,1,3,3,0,1,1};
		int[] answer = {}; 
	
		
		templist.add(arr[0]);
		
		for(int p : arr)
		{
			if(templist.get((templist.size()-1)) != p)
			{
				templist.add(p);
			}
		}
		
		answer = new int[templist.size()]; // templist사이즈크기로 answer 생성
		
		for(int p=0; p<templist.size(); p++) {
			answer[p] = templist.get(p);//값 삽입
		}
		
		System.out.println(Arrays.toString(answer));
	}

}
