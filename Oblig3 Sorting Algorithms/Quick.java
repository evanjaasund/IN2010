class Quick extends Sorter {

    void sort() {
        quickSort(0, n-1);
    }

    int partition(int low, int high){
        int p = choosePivot(low, high);
        swap(high, p);
        int pivot = A[high];
        int left = low;
        int right = high - 1;
       

        while (left <= right){
            while(leq(left, right) && leq(A[left], pivot)){
                left++;
            }
            while(geq(right, left) && geq(A[right], pivot)){
                right--;
            }
            if (lt(left, right)){
                swap(left, right);
            }
        }
        swap(left, high);
        return left;
    }

    

    int[] quickSort(int low, int high){
        if(geq(low, high)){
            return A;
    }
 
        int p = partition(low, high);
        quickSort(low, p - 1);
        quickSort(p + 1, high);
        return A;
    }

    //Denne metoden velger medianen av forste, midterste og siste tallet i A
    int choosePivot(int low, int high){
        int a = A[low];
        int b = A[Math.round(high/2)];
        int c = A[high];

        if(gt(a, b) && gt(b, c)){
            return Math.round(high/2);
        }
        else if(gt(b, a) && gt(a, c)){
            return low;
        }
        else{
            return high;
        }
    }

    String algorithmName() {
        return "quick";
    }
}
