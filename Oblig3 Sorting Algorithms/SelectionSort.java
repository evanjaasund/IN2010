class SelectionSort extends Sorter {

    void sort() {
        for(int i = 0; i < (n-1); i++){
            int k = i;
            for(int j = i+1; j < (n-1); j++){
                if(lt(A[j], A[k])){
                    k = j;
                }
            }
            if(neq(i, k)){
                swap(i, k);
            }
        }
    }

    String algorithmName() {
        return "SelectionSort";
    }
}
