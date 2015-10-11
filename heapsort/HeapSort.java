package heapsort;

import java.util.Arrays;

public class HeapSort {

	int A[] = {15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1};
	
	void MAX_HEAPIFY(int[]A, int i, int length){
		if(i>=length)
			return;
		int left = 2*i+1;
		int right = 2*i+2;
		int largest = i;
		if(left<length && A[largest]<A[left])
			largest = left;
		if(right<length && A[largest]<A[right])
			largest = right;
		if(largest!=i){
			int temp = A[largest];
			A[largest] = A[i];
			A[i] = temp;
			MAX_HEAPIFY(A, largest,length);
		}
	}
	
	void MAX_HEAPIFY_ITERATION(int[]A, int i){
		int largest = i;
		while(largest<A.length){
			int left = 2*largest+1;
			int right = 2*largest+2;
			int original = largest;
			if(left<A.length && A[largest]<A[left])
				largest = left;
			if(right<A.length && A[largest]<A[right])
				largest = right;
			if(largest!=original){
				int temp = A[largest];
				A[largest] = A[original];
				A[original] = temp;
			}else
				break;
		}
		
	}

	
	void MIN_HEAPIFY(int[]A, int i, int length){
		if(i>=length)
			return;
		int left = 2*i+1;
		int right = 2*i+2;
		int smallest = i;
		if(left<length && A[smallest]>A[left])
			smallest = left;
		if(right<length && A[smallest]>A[right])
			smallest = right;
		if(smallest!=i){
			int temp = A[smallest];
			A[smallest] = A[i];
			A[i] = temp;
			MIN_HEAPIFY(A, smallest, length);
		}
	}
	
	void BUILD_MAX_HEAP(int A[] ){
		for(int i = Math.floorDiv(A.length,2);i>=0;i--){
			MAX_HEAPIFY(A, i, A.length);
		}
	}
	
	void Heapsort(int A[]){
		BUILD_MAX_HEAP(A);
		for(int i = A.length-1;i>0;i--){
			int temp = A[0];
			A[0] = A[i];
			A[i] = temp;
			MAX_HEAPIFY(A, 0, i);
		}
	}
	
	int HEAP_MAXIMUM(int [] A){
		return A[0];
	}
	
	int heapSize = A.length;
	int HEAP_EXTRACT_MAX(int []A){
		if(heapSize == 0){
			System.out.println("Heap underflow");
			return Integer.MIN_VALUE;
		}
		int max = A[0];
		A[0] = A[heapSize-1];
		heapSize--;
		MAX_HEAPIFY(A, 0, heapSize);
		return max;
	}
	
	void HEAP_INCREASE_KEY(int [] A, int i, int key){
		if(key<A[i]){
			System.out.println("Heap underflow");
		}
		A[i] = key;
		while(i>0 && A[Math.floorDiv(i, 2)]<A[i]){
			int temp = A[Math.floorDiv(i, 2)];
			A[Math.floorDiv(i, 2)] = A[i];
			A[i] = temp;
			i = Math.floorDiv(i, 2);
		}
	}
	
	void HEAP_INCREASE_KEY_REDUCED(int [] A, int i, int key){
		if(key<A[i]){
			System.out.println("Heap underflow");
		}
		while(i>0 && A[Math.floorDiv(i, 2)]<key){
			A[i] = A[Math.floorDiv(i, 2)];
			i = Math.floorDiv(i, 2);
		}
		A[i] = key;
	}
	
	void MAX_HEAP_INSERT(int [] A, int key){
		heapSize++;
		A[heapSize] = Integer.MIN_VALUE;
		HEAP_INCREASE_KEY(A, A[heapSize], key);
	}
	
	int HEAP_MINIMUM( int A[] ){
		return A[0];
	}
	
	int HEAP_EXTRACT_MIN(int A[]){
		if(heapSize == 0){
			System.out.println("heap underflow");
			return Integer.MAX_VALUE;
		}
		int min = A[0];
		A[0] = A[heapSize-1];
		heapSize --;
		MIN_HEAPIFY(A, 0,heapSize);
		return min;
	}
	
	void HEAP_DECREASE_KEY(int A[], int i, int key){
		if(i<0 || i>heapSize-1 || A[i]<key){
			System.out.println("Error");
			return;
		}
		A[i] = key;
		while(i>0 && A[Math.floorDiv(i, 2)]>A[i]){
			int temp = A[Math.floorDiv(i, 2)];
			A[Math.floorDiv(i, 2)] = A[i];
			A[i] = temp;
			i = Math.floorDiv(i, 2);
		}
	}
	
	void MIN_HEAP_INSERT(int A[], int key){
		heapSize++;
		if(heapSize>A.length){
			System.out.println("Error");
			return;
		}
		
		A[heapSize] = Integer.MAX_VALUE;
		HEAP_DECREASE_KEY(A, heapSize-1, key);
	}
	
	public static void main(String[] args) {
		HeapSort heapSort =  new HeapSort();
		System.out.println(Arrays.toString(heapSort.A));
		System.out.println("After HEAP_INCREASE_KEY_REDUCED");
		heapSort.HEAP_INCREASE_KEY_REDUCED(heapSort.A,4,30);
		System.out.println(Arrays.toString(heapSort.A));

	}

}
