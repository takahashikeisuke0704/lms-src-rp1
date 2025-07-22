$(function() {
    $('#updateButton').on('click', function(e) {
        // 確認ダイアログ
        if (!confirm("更新します。よろしいですか？")) {
            // キャンセル → 処理中止（フォーム送信を防ぐ）
            e.preventDefault();
        }
        // OKの場合はそのままフォームが送信される
    });
});