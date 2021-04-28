import java.util.PriorityQueue;

class BalanceHeap{
    PriorityQueue que = new PriorityQueue();

    BalanceHeap(){

    }

    public void split(PriorityQueue right){
        int size = right.size();
        if (size == 1){
            System.out.println(right.poll());
        }

        else{
            PriorityQueue left = new PriorityQueue();
            for (int i = 0; i<size/2; i++){
                left.add(right.poll());
            }
            System.out.println(right.poll());
            if (right.size() >= 1) {
                split(right);
                split(left);
            }
            else{
                System.out.println(left.poll());
            }

        }

    }


    
    public static void main(String[] args) {
        BalanceHeap heap = new BalanceHeap();
        heap.que.add(0);
        heap.que.add(1);
        heap.que.add(2);
        heap.que.add(3);
        heap.que.add(4);
        heap.que.add(5);
        heap.que.add(6);
        heap.que.add(7);
        heap.que.add(8);
        heap.que.add(9);
        heap.que.add(10);
        heap.que.add(100);
        heap.que.add(30);
        heap.split(heap.que);
                
    }
}