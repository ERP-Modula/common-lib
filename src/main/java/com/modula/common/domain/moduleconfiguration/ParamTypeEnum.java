package com.modula.common.domain.moduleconfiguration;

public enum ParamTypeEnum {
    ANY("any"), // Любой тип
    ARRAY("array"), // Массив
    BOOLEAN("boolean"), // Булевый тип
    BUFFER("buffer"), // Буфер
    COLLECTION("collection"), // Коллекция
    DATE("date"), // Дата
    EMAIL("email"), // Электронная почта
    FILENAME("filename"), // Имя файла
    NUMBER("number"), // Число
    SELECT("select"), // Выбор из списка
    TEXT("text"), // Текст
    URL("url"), // URL
    UINTEGER("uinteger"); // Беззнаковое целое число

    private final String value;

    ParamTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}