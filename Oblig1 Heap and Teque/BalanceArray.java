import java.util.ArrayList;
import java.io.*;

public class BalanceArray{
    int[] done = null;
    static int counter = 0;

    public BalanceArray(int[] array){
        int high = array.length - 1;
        done = new int[array.length];
        sorted(array, 0, high);
    }
    public void sorted (int[] array, int low,int  high){

        if (high >= array.length || low < 0){
        }
        else if (high < low){
        }
        else {
            int index = ((low + high + 1)/2);
            System.out.println(array[index]);
            done[counter] = array[index];
            counter ++;
            sorted(array, index + 1, high);
            sorted(array, low, index -1);
        }
    }

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] array = in.lines().mapToInt(i -> Integer.parseInt(i)).toArray();

        BalanceArray tre = new BalanceArray(array);
        System.out.println("\n\n");
    }
}
