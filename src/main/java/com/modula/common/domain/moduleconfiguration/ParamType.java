package com.modula.common.domain.moduleconfiguration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ParamType {
    ANY("any"), // Любой тип
    ARRAY("array"), // Массив
    BOOLEAN("boolean"), // Булевый тип
    BUFFER("buffer"), // Буфер
    STRING("string"), // Строка
    COLLECTION("collection"), // Коллекция
    OBJECT("object"), // JSON объект
    DATE("date"), // Дата
    EMAIL("email"), // Электронная почта
    FILENAME("filename"), // Имя файла
    NUMBER("number"), // Число
    SELECT("select"), // Выбор из списка
    TEXT("text"), // Текст
    URL("url"), // URL
    CONNECTION("connection"); // Подключение к модулю

    private final String value;

    @Override
    public String toString() {
        return this.value;
    }
}