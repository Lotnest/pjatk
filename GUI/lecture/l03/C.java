package lecture.l03;

public class C implements A, B {

    @Override
    public void xxx() {
        A.super.xxx();
        B.super.xxx();
    }

    public static void main(String[] args) {
        new C().xxx();
    }
}
