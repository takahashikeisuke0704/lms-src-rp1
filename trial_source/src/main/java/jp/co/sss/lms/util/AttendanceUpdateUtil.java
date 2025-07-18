package jp.co.sss.lms.util;

public class AttendanceUpdateUtil {

		private AttendanceUpdateUtil() {
			
		}

		/**
		 * 出勤時間が時・分セットで入力されているかチェック
		 */
		public static boolean isStartTimeValid(Integer hour, Integer minute) {
			return (hour == null && minute == null) || (hour != null && minute != null);
		}

		/**
		 * 退勤時間が時・分セットで入力されているかチェック
		 */
		public static boolean isEndTimeValid(Integer hour, Integer minute) {
			return (hour == null && minute == null) || (hour != null && minute != null);
		}

		/**
		 * 出勤時間が退勤時間よりも前かチェック
		 */
		public static boolean isTimeOrderValid(
				Integer startHour, Integer startMinute,
				Integer endHour, Integer endMinute) {

			if (startHour == null || startMinute == null || endHour == null || endMinute == null) {
				return true; // 時間が足りない場合は順序チェックしない
			}

			int start = startHour * 60 + startMinute;
			int end = endHour * 60 + endMinute;

			return start <= end;
		}

	}



