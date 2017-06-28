package sort_algorithms;

public class InsertSort {

	public int[] insertSort(int data []){
		for(int j=1; j<data.length; j++){
			int key = data[j];
			int i = j-1;
			while(i>0 && data[i] > key){
				data[i+1] = data[i];
				i = i-1;
			}
			data[i+1] = key;
		}
		return data;
	}
	public static void main(String[] args) {
		int data[]={1,20,11,8,3,15,80,40,60};
		InsertSort in = new InsertSort();
		in.printArray(data);
		int sortdata[] = in.insertSort(data);
		in.printArray(sortdata);
	}
	public void printArray(int data[]){
		System.out.print("[");
		for (int i : data) {
			System.out.print(i+" ");
		}
		System.out.println("]");
	}
}
