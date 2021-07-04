package one.util;

import one.Main;

public enum Logger {

    TIME("[TIME] "),
    WRITE("[WRITE] "),
    READ("[READ] "),
    DELETE("[DELETE] "),
    DEBUG("[DEBUG] "),
    LEASE("[LEASE] "),
    MENU("[MENU] ");

    private final String prefix;

    Logger(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getFormattedText(String text) {
        if (text.startsWith("\n")) {
            return "\n" + prefix + text.replaceFirst("\n", "");
        }
        return prefix + text;
    }

    public void log(Object object) {
        if (this.equals(DEBUG)) {
            if (Main.DEBUG) {
                System.out.println(getFormattedText(object.toString()));
            }
        } else {
            System.out.println(getFormattedText(object.toString()));
        }
    }
}
