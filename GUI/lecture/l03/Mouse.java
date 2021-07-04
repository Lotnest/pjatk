package lecture.l03;

public class Mouse implements USB {

    @Override
    public void send(byte[] data) {
        System.out.println("Connected");
    }

    @Override
    public byte[] receive() {
        return new byte[]{127, 87, 90};
    }
}
