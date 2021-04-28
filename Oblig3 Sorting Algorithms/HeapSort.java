class HeapSort extends Sorter {

    void sort() {
        buildMaxHeap(A, n);
        for(int i = n-1; i > 0; i--){
            swap(i, 0);
            bubbleDown(A, 0, i);
        }
    }

    void buildMaxHeap(int[] A, int n){
        for(int i = n/2; i >= 0; i--){
            bubbleDown(A, i , n);
        } 
    }

    void bubbleDown(int[] A, int i, int n){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(lt(left, n) && lt(A[largest], A[left])){
            int temp = largest;
            largest = left;
            left = temp;
        }

        if(lt(right, n) && lt(A[largest], A[right])){
            int temp = largest;
            largest = right;
            right = temp;
        }

        if(neq(i, largest)){
            swap(i, largest);
            bubbleDown(A, largest, n);
        }
    }

    String algorithmName() {
        return "HeapSort";
    }
}
