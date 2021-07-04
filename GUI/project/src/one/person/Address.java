package one.person;

import one.util.Logger;
import one.util.Validator;

import java.util.Objects;

public class Address {

    private String street;
    private String ZIPCode;
    private String city;
    private String country;

    public Address(final String street, final String ZIPCode, final String city, final String country) {
        this.street = street;
        this.ZIPCode = Validator.validateZIPCode(ZIPCode);
        this.city = city;
        this.country = country;

        Logger.DEBUG.log("Initialized " + this);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getZIPCode() {
        return ZIPCode;
    }

    public void setZIPCode(final String ZIPCode) {
        this.ZIPCode = ZIPCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(ZIPCode, address.ZIPCode) && Objects.equals(city, address.city) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, ZIPCode, city, country);
    }

    @Override
    public String toString() {
        return street + ", " + ZIPCode + ", " + city + ", " + country;
    }
}
