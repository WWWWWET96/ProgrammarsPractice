package practice;
import java.util.ArrayList;
import java.util.Arrays;
// �迭�� ����Ʈ ����? list�� �迭ó�� ������ ũ�� ������ ���� �ƴ϶� �޸𸮰� ����ϴ� �� �ڵ����� arraylistũ�� �������� ����
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
			answer[p] = templist.get(p);//�� ����
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
		
		answer = new int[templist.size()]; // templist������ũ��� answer ����
		
		for(int p=0; p<templist.size(); p++) {
			answer[p] = templist.get(p);//�� ����
		}
		
		System.out.println(Arrays.toString(answer));
	}

}
