package lecture.l03;

public class Computer {

    public void connect(USB usb) {
        usb.send(new byte[]{1});
        byte[] data = usb.receive();
        // actions
    }
}
