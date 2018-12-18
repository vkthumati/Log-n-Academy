package com.lognacademy.heap;

public class MinHeap {
	private int[] heap;
	private int size;
	private int maxSize;
	private static final int FRONT = 1;
	
	public MinHeap(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		heap = new int[this.maxSize+1];
		heap[0]=Integer.MIN_VALUE;
	}
	
	private int parent(int indexPosition) {
		return indexPosition/2;
	}
	
	private int leftChild(int indexPosition) {
		return 2*indexPosition;
	}
	
	private int rightChild(int indexPosition) {
		return (2*indexPosition)+1;
	}
	
	private void swap(int firstPos, int secondPos) {
		int tmp;
		tmp = heap[firstPos];
		heap[firstPos] = heap[secondPos];
		heap[secondPos] = tmp;
	}
	
	public void insert(int element) {
		heap[++size] = element;
		int current = size;
		
		while(heap[current] < heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}
	
	public void print() {
		for(int i=1; i<=size/2;i++) {
			System.out.print("PARENT : "+heap[i]+" LEFT CHILD : "+heap[2*i]+" RIGHT CHILD : "+heap[2*i+1]);
			System.out.println();
		}
	}
	
	public int remove() {
		int popped = heap[FRONT];
		heap[FRONT] = heap[size--];
		minHeapify(FRONT);
		return popped;
	}
	
	public void minHeap(){
        for (int pos = (size / 2); pos >= 1 ; pos--){
            minHeapify(pos);
        }
    }
	
	private void minHeapify(int pos) {
		if(!isLeaf(pos)) {
			if(heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]) {
				if(heap[leftChild(pos)] < heap[rightChild(pos)]) {
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				}else {
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
		
	}
	
	private boolean isLeaf(int pos) {
		if(pos >= (size/2) && pos <= size) {
			return true;
		}
		return false;
	}
	
	public static void main(String... args) {
		System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.minHeap();
 
        minHeap.print();
        System.out.println("The Min val is " + minHeap.remove());
        minHeap.print();
		
	}
}
