package sort_algorithms;

public class BubbleSort {
	
	public int[] bubbleSort(int data[]){
		for(int i=0; i < data.length; i++)
			for(int j=data.length-1; j > i+1; j--){
				if(data[j]<data[j-1]){
					int temp = data[j];
					data[j] = data[j-1];
					data[j-1] = temp;
				}
			}
		return data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[]={1,20,11,8,3,15,80,40,60};
		BubbleSort bubble = new BubbleSort();
		InsertSort in = new InsertSort();
		in.printArray(data);
		bubble.bubbleSort(data);
		in.printArray(data);
	}

}
