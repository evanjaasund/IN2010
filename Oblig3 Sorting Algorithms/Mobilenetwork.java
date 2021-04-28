import java.io.File;
import java.io.FileReader;
import java.util.Scanner;



class Mobilenetwork{

    static int[][] mobileNetwork;
    static boolean[] visited;
    static int price = 0;
    static int size;
    
    public static void main(String[] args) throws Exception {
        String filename = args[0];
        File file = new File(filename);
        Scanner in = new Scanner(file);
        size = in.nextInt();
        mobileNetwork = new int[size][size];
        visited = new boolean[size];
        while(in.hasNextInt()){
            int tower_from = in.nextInt();
            int tower_to = in.nextInt();
            int value = in.nextInt();
            mobileNetwork[tower_from-1][tower_to-1] = value;
            mobileNetwork[tower_to-1][tower_from-1] = value;
        }
        System.out.println(mostExpensive(0));
        price = 0;
        reset();
        System.out.println(leastExpensive(0));
    
    }

    //Method for finding the most expensive price.
    static int mostExpensive(int next_tower){
        visited[next_tower] = true;
        int largest = 0;
        int next = 0;
        for (int i = 0; i < size; i++){
            if(mobileNetwork[next_tower][i] > largest && visited[i] != true){
                largest = mobileNetwork[next_tower][i];
                next = i;
            }
        }
        price += largest;
        if(largest != 0){
            return mostExpensive(next);
        }
        return price;
    }

    //Method for finding the least expensive price.
    static int leastExpensive(int next_tower){
        visited[next_tower] = true;
        int lowest = 10000;
        int next = 0;
        for (int i = 0; i < size; i++){
            if(visited[i] != true){
                if(mobileNetwork[next_tower][i] != 0 && mobileNetwork[next_tower][i] < lowest){
                    lowest = mobileNetwork[next_tower][i];
                    next = i;
                }
            }
        }
        if(lowest != 10000){
            price += lowest;
            return leastExpensive(next);
        }

        //Checking if there are any unvisited towers.
        for(int j = 0; j < size; j++){
            int last = 10000;
            if(!visited[j]){
                for (int k = 0; k < size; k++){
                    if(mobileNetwork[j][k] != 0 && mobileNetwork[j][k] < last){
                        lowest = mobileNetwork[j][k];
                    }
                }
                price += lowest;
            }
        }
        return price;
    }

    //Resetting all visited towers.
    static void reset(){
        for (int i = 0; i < size; i++){
            visited[i] = false;
        }
    }
}