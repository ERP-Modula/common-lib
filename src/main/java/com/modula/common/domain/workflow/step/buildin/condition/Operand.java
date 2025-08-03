//package com.modula.common.domain.workflow.step.buildin.condition;
//
//import com.modula.common.domain.moduleconfiguration.ParamType;
//import jakarta.persistence.Embeddable;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import lombok.Data;
//
//@Embeddable
//@Data
//public class Operand {
//
//    @Enumerated(EnumType.STRING)
//    private OperandType type; // CONSTANT или VARIABLE
//
//    private String value; // Значение константы или JSONPath к данным
//
//    // Для переменных - тип данных (если известно)
//    @Enumerated(EnumType.STRING)
////    private DataType dataType;
//    private ParamType dataType;
//}