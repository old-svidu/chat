/**
 * Created by root on 14.03.17.
 */
public class Main {

    public static void main(String[] args) {
//        Thread th1 = new Thread(new Producer());
//        Thread th2 = new Thread(new Consumer());
//        th1.start();
//        th2.start();
        Chatter chatter = new Chatter();
        chatter.chatter("tcp://localhost:61616","user1");
    }
}
