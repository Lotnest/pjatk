package lecture.l03;

public enum StudentSortType {

    BYAGE(1, "by age"),
    BYNAME(2, "by name");

    private final int sortType;
    private final String sortDescription;

    StudentSortType(int sortType, String sortDescription) {
        this.sortType = sortType;
        this.sortDescription = sortDescription;
    }

    public int getSortType() {
        return sortType;
    }

    public String getSortDescription() {
        return sortDescription;
    }
}
