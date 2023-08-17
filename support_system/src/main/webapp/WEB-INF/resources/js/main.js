/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
function deleteObject(path) {
    console.log(path);
    if (confirm("Bạn chắc chắn muốn xóa tin này không?") === true) {
        fetch(path, {
            method: "DELETE"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Hệ thống có lỗi! Vui lòng quay lại sau!");
        });
    }
}

function makeQuestion(id) {
    console.log(id);
    document.getElementById("questionInput").style.display = "block";
}