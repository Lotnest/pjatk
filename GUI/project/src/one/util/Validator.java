package one.util;

import one.person.Osoba;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Validator {

    public static String validatePESEL(final String PESEL) {
        //Just length and number-only validation, doesn't check if it's a real PESEL
        final Pattern pattern = Pattern.compile("\\d{11}");
        if (!pattern.matcher(PESEL).matches()) {
            throw new IllegalArgumentException("Invalid PESEL: " + PESEL);
        }
        return PESEL;
    }

    public static String validateZIPCode(final String ZIPCode) {
        final Pattern pattern = Pattern.compile("\\d{2}-\\d{3}");
        if (!pattern.matcher(ZIPCode).matches()) {
            throw new IllegalArgumentException("Invalid ZIP Code: " + ZIPCode);
        }
        return ZIPCode;
    }

    public static double validateLength(final double a) {
        if (a < 0.0) {
            throw new IllegalArgumentException("Invalid length: " + a);
        }
        return a;
    }

    public static double validateVolume(final double volume) {
        if (volume < 0.0) {
            throw new IllegalArgumentException("Invalid volume: " + volume);
        }
        return volume;
    }

    public static LocalDate validateBirthDate(final LocalDate birthDate) {
        if (TimeUtil.getDate().toEpochDay() < birthDate.toEpochDay()) {
            throw new IllegalArgumentException("Invalid birth date (Date in future): " + birthDate);
        }
        return birthDate;
    }

    public static LocalDate validateLeaseEndDate(final LocalDate leaseEndDate, final LocalDate leaseStartDate) {
        if (leaseEndDate.toEpochDay() <= leaseStartDate.toEpochDay()) {
            throw new IllegalArgumentException("Invalid lease end date: (Date in the past compared to start date): " + leaseEndDate);
        }
        return leaseEndDate;
    }

    public static Osoba validateTenant(final Osoba tenant) {
        if (tenant != null) {
            if (tenant.getLetters().size() > 3) {
                try {
                    throw new ProblematicTenantException("Osoba " + tenant.getFullName() + " posiadała już najem pomieszczeń: " + tenant.getLetterRooms());
                } catch (ProblematicTenantException e) {
                    e.printStackTrace();
                }
            } else if (tenant.getRentals() != null && tenant.getRentals().size() > 5) {
                try {
                    throw new ProblematicTenantException("Osoba " + tenant.getFullName() + " posiada już maksymalną ilość pomieszczeń: 5");
                } catch (ProblematicTenantException e) {
                    e.printStackTrace();
                }
            } else {
                return tenant;
            }
        }
        return null;
    }
}
