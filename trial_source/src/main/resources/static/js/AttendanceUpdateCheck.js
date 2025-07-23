document.getElementById("updateButton").addEventListener("click", function(e) {
    const confirmed = window.confirm("更新します。よろしいですか？");
    if (!confirmed) {
        e.preventDefault(); // 処理を中断
    }
});