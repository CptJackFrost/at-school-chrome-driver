package stepDef;

public enum Category {
    Автомобили("#category option[value='9']"),
    Мотоциклы("#category option[value='14']"),
    Квартиры("#category option[value='24']"),
    Комнаты("#category option[value='23']"),
    Вакансии("#category option[value='111']"),
    Резюме("#category option[value='112']"),
    Растения("#category option[value='106']"),
    Телефоны("#category option[value='84']"),
    Оргтехника("#category option[value='99']"),
    Коллекционирование("#category option[value='36']");


    public String value;

    public String getValue() {
        return value;
    }

    Category(String value) {
        this.value = value;
    }
}
