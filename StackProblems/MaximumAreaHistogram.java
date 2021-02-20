import java.util.*;

//The Array is the heights of buildings and have a width of 1 unit. We need to Find the rectangle with max. area.


public class MaximumAreaHistogram {
	
	private static ArrayList<Integer> shorterToRightIndex(int[] arr){
		Stack<int[]> st = new Stack<int[]>();
		ArrayList<Integer> out = new ArrayList<Integer>();
		
		for(int i=arr.length-1;i>=0;i--){
			if(st.empty()){
				out.add(arr.length);
			}else if(!st.empty() && arr[i]>st.peek()[0]){
				out.add(st.peek()[1]);
			}else if(!st.empty() && arr[i]<=st.peek()[0]){
				while(!st.empty() && arr[i]<=st.peek()[0]){
					st.pop();
				}
				if(st.empty()){
					out.add(arr.length);
				}else if(!st.empty()){
					out.add(st.peek()[1]);
				}
			}
			
			
			int[] pair = {arr[i],i};
			st.push(pair);
		}
		Collections.reverse(out);
		return out;
	}
	
	private static ArrayList<Integer> shorterToLeftIndex(int[] arr){
		Stack<int[]> st = new Stack<int[]>();
		ArrayList<Integer> out = new ArrayList<Integer>();
		
		for(int i=0;i<arr.length;i++){
			if(st.empty()){
				out.add(-1);
			}else if(!st.empty() && arr[i]>st.peek()[0]){
				out.add(st.peek()[1]);
			}else if(!st.empty() && arr[i]<=st.peek()[0]){
				while(!st.empty() && arr[i]<=st.peek()[0]){
					st.pop();
				}
				if(st.empty()){
					out.add(-1);
				}else if(!st.empty()){
					out.add(st.peek()[1]);
				}
			}
			
			int[] pair = {arr[i],i};
			st.push(pair);
		}
		return out;
	}
	
	private static int maxArea(int[] arr) {
		int max = arr[0];
		ArrayList<Integer> out = new ArrayList<Integer>();
		
		ArrayList<Integer> rightIndex = shorterToRightIndex(arr);
		ArrayList<Integer> leftIndex = shorterToLeftIndex(arr);
		
		for(int i=0;i<arr.length;i++){
			out.add(arr[i]*(rightIndex.get(i)-leftIndex.get(i)-1));
		}
		
		for(int a:out){
			if(a>max){
				max = a;
			}
		}
		return max;
	}
	
	public static void main(String[] args){
		
		int[] arr = {1,4,7,8,3,2,6,8};
		
		System.out.println(maxArea(arr));
		
	}

}
