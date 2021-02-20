import java.util.*;

// find the first higher number on the right of the element in the array
public class FirstHigherNumberRight {

	public static ArrayList<Integer> HighestNumberArray(int[] arr){
		ArrayList<Integer> out = new ArrayList<Integer>();
		Stack<Integer> st = new Stack<Integer>();
		for(int i=arr.length-1;i>=0;i--){
			if(st.empty()){
				//st.push(arr[i]);
				out.add(-1);
			}else if(!st.empty() && arr[i]<st.peek()){
				//st.push(arr[i]);
				out.add(st.peek());
			}else if(!st.empty() && arr[i]>=st.peek()){
				while(!st.empty() && arr[i]>=st.peek()){
					st.pop();
				}
				if(st.empty()){
					out.add(-1);
				}else if(!st.empty() && arr[i]<st.peek()){
					out.add(st.peek());
				}
			}
			st.push(arr[i]);
		}
		Collections.reverse(out);
		return out;
	}
	
	public static void main(String[] args){
		int[] arr={1,5,6,4,2,3,5};
		ArrayList<Integer> output = HighestNumberArray(arr);
		for(int a:output){
			System.out.println(a);
		}
	}
}
