package com.boj.guidance.util.annotation;

import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.annotations.ValueGenerationType;

import java.lang.annotation.*;

@IdGeneratorType(LockSerialGenerator.class)
@ValueGenerationType(generatedBy = LockSerialGenerator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LockSerial {
    enum LockType{DEFAULT, TRYLOCK};
    LockType lockType() default LockType.DEFAULT;
}
