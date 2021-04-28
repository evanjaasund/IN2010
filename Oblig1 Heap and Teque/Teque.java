import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Teque<T>{
  public Node first, middle, last = null;
  public int balance = 0;
  protected int size = 0;


  public class Node{
    public T data;
    public Node next, previous;

    public Node(T x){
      data = x;
    }

  }


  public void push_back(T x){
    Node n = new Node(x);
      if (balance > 1){
      middle = middle.next;
      balance = 0;
    }
    if (size == 0){
      first = n;
      middle = n;
    }
    else{
      last.next = n;
      n.previous = last;
      n.next = first;
      balance ++;
    }
    size ++;
    last = n;
  }

  public void push_front(T x){
    Node n = new Node(x);
    if (size == 0){
      last = n;
      middle = n;
    }
    else{
      balance --;
      if (balance < -1){
        middle = middle.previous;
        balance = 0;
      }
      first.previous = n;
      n.next = first;
      n.previous = last;
    }
    size ++;
    first = n;
  }

  public void push_middle(T x){
    Node n = new Node(x);
    if (size == 0){
      last = n;
      first = n;
      middle = n;
    }
    else{
      if (balance >= 0){
        n.next = middle.next;
        middle.next = n;
        middle.next.previous = n;
        n.previous = middle;
        if (balance == 1){
          middle = n;
          balance = 0;
        }
        else {
          balance ++;
        }
      }
      else{
        n.previous = middle.previous;
        n.previous.next = n;
        middle.previous = n;
        n.next = middle;
        balance = 0;
        middle = n;
      }
    }
    size ++;
  }

  public void print(){
    System.out.println("\nPrinter elementer");
    Node n = first;
    for (int i = 0; i<size; i++){
      System.out.println(n.data);
      n = n.next;
    }
    System.out.println("\n");
  }

  public void get(int index){
    Node n = first;
    if (index > size/2){
      for (int i = 0; i<size-index; i++){
        n = n.previous;
      }
    }
    else{
      for (int i = 0; i<index; i++){
        n = n.next;
      }
    }
    System.out.println(n.data);
  }


  public static void main(String[] args) throws FileNotFoundException{
    Teque q = new Teque();
    String filnavn = args[0];
    File minFil = new File(filnavn);
    Scanner sc = new Scanner(minFil);
    sc.nextLine();

    while(sc.hasNextLine()){
      String[] a = sc.nextLine().split(" ");
      int number = Integer.parseInt(a[1]); 

      if(a[0].contains("push_back")){
        q.push_back(number);
      }

      else if (a[0].contains("push_front")){
        q.push_front(number);
      }

      else if (a[0].contains("push_middle")){
        q.push_middle(number);
      }

      else if(a[0].contains("get")){
        q.get(number);
      }
    }

  }
}
