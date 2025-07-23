package jp.co.sss.lms.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jp.co.sss.lms.form.DailyAttendanceForm;

/**
 * 検証クラス
 */
public class AttendanceUpdateUtil implements ConstraintValidator<AttendanceUpdateValidation, DailyAttendanceForm> {

	@Override
	public boolean isValid(DailyAttendanceForm form, ConstraintValidatorContext context) {
	    // 勤怠が完全に未入力ならスキップ（null許容）
	    if (form.getTrainingStartHour() == null && form.getTrainingStartMinute() == null &&
	        form.getTrainingEndHour() == null && form.getTrainingEndMinute() == null) {
	        return true;
	    }

	    // 出勤時刻が一部だけ入力された場合
	    if ((form.getTrainingStartHour() != null && form.getTrainingStartMinute() == null) ||
	        (form.getTrainingStartHour() == null && form.getTrainingStartMinute() != null)) {
	        context.disableDefaultConstraintViolation();
	        context.buildConstraintViolationWithTemplate("出勤時間が正しく入力されていません。")
	               .addPropertyNode("trainingStartHour").addConstraintViolation();
	        return false;
	    }

	    // 退勤時刻が一部だけ入力された場合
	    if ((form.getTrainingEndHour() != null && form.getTrainingEndMinute() == null) ||
	        (form.getTrainingEndHour() == null && form.getTrainingEndMinute() != null)) {
	        context.disableDefaultConstraintViolation();
	        context.buildConstraintViolationWithTemplate("退勤時間が正しく入力されていません")
	               .addPropertyNode("trainingEndHour").addConstraintViolation();
	        return false;
	    }

	    // 全て正しく入力 or 両方未入力
	    return true;
	}}