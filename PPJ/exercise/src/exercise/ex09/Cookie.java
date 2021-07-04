package exercise.ex09;

public class Cookie {

    private final String manufacturer;
    private final double mass;
    private final String productCode;

    public Cookie(String manufacturer, double mass, String productCode) {
        this.manufacturer = manufacturer;
        this.mass = mass;
        this.productCode = productCode;
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "manufacturer='" + manufacturer + '\'' +
                ", mass=" + mass +
                ", productCode='" + productCode + '\'' +
                '}';
    }
}
