/**
 * Created by root on 14.03.17.
 */
public class Chat {
    public static void main(String[] args) {
        Chatter chatter = new Chatter();
        chatter.chatter("tcp://localhost:61616","user2");
    }
}
