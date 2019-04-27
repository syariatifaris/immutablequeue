import imqueue.QueueImpl;

public class Main {
    public static void main(String []args){
        QueueImpl<Integer> ique = new QueueImpl<Integer>();
        ique = ique.enQueue(10);
        ique = ique.enQueue(11);
        ique = ique.enQueue(12);
    }
}
