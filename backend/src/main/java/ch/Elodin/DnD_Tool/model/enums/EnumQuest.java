package ch.Elodin.DnD_Tool.model.enums;

public enum EnumQuest {
offen, abgeschlossen;

    public static EnumQuest fromString(String value) {
        return EnumQuest.valueOf(value.trim().toUpperCase());
    }

}
