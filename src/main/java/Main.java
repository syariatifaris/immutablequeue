import imqueue.QueueImpl;
import imqueue.Queue;

public class Main {
    public static void main(String []args){
        Queue<Integer> ique = new QueueImpl<Integer>();
        ique = ique.enQueue(10);
        ique = ique.enQueue(11);
        ique = ique.enQueue(12);
    }
}
