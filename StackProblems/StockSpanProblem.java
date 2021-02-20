import java.util.*;

//find the number of consecutive elements smaller than or equal to the number on it's left in an array including itself
//the elements in the array are daily stock prices. if there is no smaller number on the left answer is 1(the number itself)
public class StockSpanProblem {
	
	private static ArrayList<Integer> solveStockSpan(int[] arr){
		ArrayList<Integer> out = new ArrayList<Integer>();
		Stack<int[]> st = new Stack<int[]>();
		
		for(int i=0;i<arr.length;i++){
			if(st.empty()){
				out.add(i+1);
			}else if(!st.empty() && arr[i]<st.peek()[0]){
				out.add(i-st.peek()[1]);
			}else if(!st.empty() && arr[i]>=st.peek()[0]){
				while(!st.empty() && arr[i]>=st.peek()[0]){
					st.pop();
				}
				
				if(st.empty()){
					out.add(i+1);
				}else if(!st.empty() && arr[i]<st.peek()[0]){
					out.add(i-st.peek()[1]);
				}
			}
			int[] temp = {arr[i],i};
			st.push(temp);
		}
		
		return out;
	}
	
	public static void main(String[] args){
		//Scanner s=new Scanner(System.in);
		//int n = s.nextInt();
		int[] arr = {100,80,70,60,85,90};
		ArrayList<Integer> out = solveStockSpan(arr);
		
		for(int a:out){
			System.out.println(a);
		}
	}

}
