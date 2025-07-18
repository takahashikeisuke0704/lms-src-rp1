$(function() {
	$('#updateButton').on('click', function(e) {
		let hasError = false;

		$('tr').each(function() {
			const startHour = $(this).find('select[name$=".trainingStartHour"]').val();
			const startMinute = $(this).find('select[name$=".trainingStartMinute"]').val();
			const endHour = $(this).find('select[name$=".trainingEndHour"]').val();
			const endMinute = $(this).find('select[name$=".trainingEndMinute"]').val();

			if ((startHour && !startMinute) || (!startHour && startMinute)) {
				alert("出勤時間が正しく入力されていません。");
				hasError = true;
				return false; // break
			}

			if ((endHour && !endMinute) || (!endHour && endMinute)) {
				alert("退勤時間が正しく入力されていません。");
				hasError = true;
				return false; // break
			}
		});

		if (hasError) {
			e.preventDefault();
			return;
		}

		if (!confirm("更新します。よろしいですか？")) {
			e.preventDefault();
		}
	});
});