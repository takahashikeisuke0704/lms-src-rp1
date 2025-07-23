package jp.co.sss.lms.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * アノテーションクラス
 */
@Documented
@Constraint(validatedBy = AttendanceUpdateUtil.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AttendanceUpdateValidation {
    String message() default "時刻の入力に不備があります。";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}