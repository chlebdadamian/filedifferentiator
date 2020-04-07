package filedifferentator;

import java.util.HashMap;
import java.util.Map;

public enum ExtDatabase {

    TXT(""),
    GIF("47494638"),
    JPG("FFD8FFDB", "FFD8FFE0", "FFD8FFEE", "FFD8FFEE"),
    TIF("49492A00", "4D4D002A", "4D4D002B"),
    CLASS("CAFEBABE"),
    AVI("52494646"),
    MOV("6D6F6F76"),
    ZIP("504B0304","504B0308"),
    TAR("75737461"),
    PDF("25504446"),
    PNG("89594E47", "89504E47"),
    PSD("38425053"),
    MIDI("4D546864"),
    WAV("52494646"),
    WEBM("1A45DFA3"),
    MKV("1A45SFA3", "1A45DFA3");

    private String[] magicNumber;
    private static final Map<String, String[]> EXT_DATABASE_MAP;

    ExtDatabase(String... magicNumber) {
        this.magicNumber = magicNumber;
    }

    static {
        EXT_DATABASE_MAP = new HashMap<>();
        for (ExtDatabase ext: ExtDatabase.values()) {
            EXT_DATABASE_MAP.put(ext.name(), ext.magicNumber);
        }
    }

    public static String[] get(String name) {
        return EXT_DATABASE_MAP.get(name);
    }

}
