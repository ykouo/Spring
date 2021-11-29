    class ToCSV {
        constructor() {
        // CSV 버튼에 이벤트 등록
        document.querySelector('#csvDownloadButton').addEventListener('click', e => {
            e.preventDefault()
            this.getCSV('EmployeeList.csv')
        })
    }

    downloadCSV(csv, filename) {
        var csvFile;
        var downloadLink;

        // CSV 파일을 위한 Blob 생성
        csvFile = new Blob([csv], {type: "text/csv"})
        // Download link를 위한 a엘리멘트 생성
        downloadLink = document.createElement("a")
        // 다운받을 csv 파일 이름 지정하기
        downloadLink.download = filename;
        // blob과 링크를 연결
        downloadLink.href = window.URL.createObjectURL(csvFile)
        // 링크 숨기기 
        downloadLink.style.display = "none"
        // HTML 가장 아래 부분에 링크를 붙여줍시다.
        document.body.appendChild(downloadLink)

        // 클릭 이벤트를 발생시켜 실제로 브라우저가 '다운로드'하도록 만들어줍시다.
        downloadLink.click()
    }

    getCSV(filename) {
        // csv의 내용을 담기위한 빈배열 생성 
        const csv = []
       //  tr 정보를 담을 변수 
        const rows = document.querySelectorAll("#csvtable tr")

        for (var i = 0; i < rows.length; i++) {
            const row = [], cols = rows[i].querySelectorAll("td, th")
            for (var j = 0; j < cols.length; j++)
                row.push(cols[j].innerText)
            csv.push(row.join(",")) 
        }

        // Download CSV
        this.downloadCSV(csv.join("\n"), filename)
    }
}

document.addEventListener('DOMContentLoaded', e => {
    new ToCSV()
})