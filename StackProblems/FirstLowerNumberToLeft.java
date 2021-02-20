import java.util.*;

//find the first lower number on the left of the element in the array

public class FirstLowerNumberToLeft {

	public static ArrayList<Integer> LowestNumberArray(int[] arr) {
		Stack<Integer> st = new Stack<Integer>();
		ArrayList<Integer> out = new ArrayList<Integer>();
		
		for(int i=0;i<arr.length;i++){
			if(st.empty()){
				out.add(-1);
			}else if(!st.empty() && arr[i]>st.peek()){
				out.add(st.peek());
			}else if(!st.empty() && arr[i]<=st.peek()){
				while(!st.empty() && arr[i]<=st.peek()){
					st.pop();
				}
				if(st.empty()){
					out.add(-1);
				}else if(!st.empty() && arr[i]>st.peek()){
					out.add(st.peek());
				}
				
			}
			st.push(arr[i]);
		}
		return out;
	}
	
	public static void main(String[] args){
		int[] arr={1,5,6,4,2,3,5};
		ArrayList<Integer> output = LowestNumberArray(arr);
		for(int a:output){
			System.out.println(a);
		}
	}


}
