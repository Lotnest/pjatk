package lecture.l03;

public interface USB {

    void send(byte[] data);

    byte[] receive();
}
