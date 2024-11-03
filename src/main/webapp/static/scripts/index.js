"use strict";

const canvas = document.getElementById("figureCanvas");
canvas.width = document.getElementById("frame").offsetWidth;
canvas.height = document.getElementById("frame").offsetHeight;
const intervalSize = canvas.height / 10;
const ctx = canvas.getContext("2d");


drawCoordinateLines();
canvas.addEventListener("click", (e) => {
    const rect = canvas.getBoundingClientRect();
    let x = e.clientX - rect.left;
    let y = e.clientY - rect.top;
    let xMapped = (e.clientX - rect.left - canvas.width / 2) / intervalSize;
    let yMapped = (canvas.height / 2 - e.clientY + rect.top) / intervalSize;
    const rInput = document.getElementById("r-inp");
    const resultTable = document.querySelectorAll("#results tbody");

    if (checkR(rInput.value)) {
        const url = new URL('http://localhost:8080/lab2_app/main');
        url.searchParams.append('x', xMapped.toString());
        url.searchParams.append('y', yMapped.toString());
        url.searchParams.append('r', rInput.value);
        url.searchParams.append('areaClick', "true");
        fetch(url)
            .then(response => response.json())
            .then(data => {
                let resultText = "Промах";
                if (data["result"]){
                    drawPoint(x, y);
                    resultText = "Попадание"
                }
                resultTable[0].innerHTML += `<tr>
                                                <td>${xMapped}</td>
                                                <td>${yMapped}</td>
                                                <td>${rInput.value}</td>
                                                <td>${resultText}</td>
                                            </tr>`;
            });
    }
});
