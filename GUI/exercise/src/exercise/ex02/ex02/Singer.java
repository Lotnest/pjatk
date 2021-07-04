package exercise.ex02.ex02;

public abstract class Singer {

    private static Integer lastStartNumber = 0;
    private final String lastName;
    private final Integer startNumber;

    public Singer(String lastName) {
        this.lastName = lastName;
        startNumber = lastStartNumber++;
    }

    public static Singer loudest(Singer[] singers) {
        Singer loudestSinger = null;
        for (Singer singer : singers) {
            if (loudestSinger == null) {
                loudestSinger = singer;
            } else if (singer.countUpperCase() > loudestSinger.countUpperCase()) {
                loudestSinger = singer;
            }
        }
        return loudestSinger;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getStartNumber() {
        return startNumber;
    }

    public abstract String sing();

    @Override
    public String toString() {
        return "Singer{" +
                "lastName='" + lastName + '\'' +
                ", startNumber=" + startNumber +
                '}';
    }

    private Integer countUpperCase() {
        int upperCases = 0;
        char[] array = sing().toCharArray();
        for (char c : array) {
            if (Character.isUpperCase(c)) {
                upperCases++;
            }
        }
        return upperCases;
    }
}
