package stepDef;

public enum Price {

    По_умолчанию("//option[text()='По умолчанию']"),
    Дешевле("//option[text()='Дешевле']"),
    Дороже("//option[text()='Дороже']"),
    По_дате("//option[text()='По дате']");

    public String value;

    public String getValue() {
        return value;
    }

    Price(String value) {
        this.value = value;
    }
}
