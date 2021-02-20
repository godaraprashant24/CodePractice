import java.util.*;

//Find the max area of rectangle in the binary matrix

public class maxAreaBinaryRectangle {

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
		ArrayList<Integer> out = new ArrayList<Integer>();
		
		ArrayList<Integer> rightIndex = shorterToRightIndex(arr);
		ArrayList<Integer> leftIndex = shorterToLeftIndex(arr);
		
		for(int i=0;i<arr.length;i++){
			out.add(arr[i]*(rightIndex.get(i)-leftIndex.get(i)-1));
		}
		
		return max(out);
	}
	
	private static int max(int[] arr){
		int max=arr[0];
		for(int a:arr){
			if(a>max){
				max = a;
			}
		}

		System.out.println(max);
		return max;
	}
	
	private static int max(ArrayList<Integer> arr){
		int max=arr.get(0);
		for(int a:arr){
			if(a>max){
				max = a;
			}
		}
		return max;
	}
	
	private static int maxAreaBinaryRectangle(int[][] arr){
		int[] hist = new int[arr[0].length];
		ArrayList<Integer> out = new ArrayList<Integer>();
		
		for(int j=0;j<arr[0].length;j++){
			hist[j]=arr[0][j];
		}
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				if(arr[i][j]==0){
					hist[j]=0;
				}else{
					hist[j]=hist[j]+arr[i][j];
				}
			}
			out.add(maxArea(hist));
		}
		return max(out);
	}
	
	public static void main(String[] args){
		
		int[][] arr = {{0,1,1,0},{1,1,1,1},{1,1,0,0},{1,1,1,1}};
		
		System.out.println(maxAreaBinaryRectangle(arr));
		
	}
}
