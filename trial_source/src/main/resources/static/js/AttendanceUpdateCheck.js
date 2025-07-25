document.getElementById("updateButton").addEventListener("click", function(e) {
    const confirmed = window.confirm("更新します。よろしいですか？");
    if (!confirmed) {
        e.preventDefault(); 
    }
});