package jp.co.sss.lms.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jp.co.sss.lms.form.DailyAttendanceForm;

public class AttendanceUpdateUtil implements ConstraintValidator<AttendanceUpdateValidation, DailyAttendanceForm> {

    @Override
    public boolean isValid(DailyAttendanceForm form, ConstraintValidatorContext context) {
        boolean valid = true;

        // 出勤時刻：時間と分の両方が入っていない場合はNG
        if ((form.getTrainingStartHour() != null && form.getTrainingStartMinute() == null) ||
            (form.getTrainingStartHour() == null && form.getTrainingStartMinute() != null)) {

            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("出勤時間が正しく入力されていません。")
                   .addBeanNode()  // リスト要素全体にエラーを付与
                   .addConstraintViolation();
            valid = false;
        }

        // 退勤時刻：時間と分の両方が入っていない場合はNG
        if ((form.getTrainingEndHour() != null && form.getTrainingEndMinute() == null) ||
            (form.getTrainingEndHour() == null && form.getTrainingEndMinute() != null)) {

            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("退勤時間が正しく入力されていません。")
                   .addBeanNode()  // リスト要素全体にエラーを付与
                   .addConstraintViolation();
            valid = false;
        }

        return valid;
    }
}