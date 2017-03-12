package ae.starzplay.assignment.entity;

/**
 * Created by Jagwani on 3/1/2017.
 */
public enum FilterType {

    CENSORING("censoring"),
    LEVEL_UNCENSORED("uncensored"),
    LEVEL_CENSORED("censored");

    private final String value;

    private FilterType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
