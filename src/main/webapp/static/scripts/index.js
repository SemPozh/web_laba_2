"use strict";

const canvas = document.getElementById("figureCanvas");
canvas.width = document.getElementById("frame").offsetWidth;
canvas.height = document.getElementById("frame").offsetHeight;
const intervalSize = canvas.height / 10;
const ctx = canvas.getContext("2d");
const rNotSelectedError = document.getElementById("rNotSelectedError");
const incorrectFormError = document.getElementById("Incorrect");
const mainForm = document.getElementById("form");
const yInput = document.getElementById("y-inp");
const rInput = document.getElementById("r-inp");

drawCoordinateLines();

canvas.addEventListener("click", (e) => {
    const rect = canvas.getBoundingClientRect();
    let x = e.clientX - rect.left;
    let y = e.clientY - rect.top;
    let xMapped = (e.clientX - rect.left - canvas.width / 2) / intervalSize;
    let yMapped = (canvas.height / 2 - e.clientY + rect.top) / intervalSize;
    const resultTable = document.querySelectorAll("#results tbody");

    if (checkR(rInput.value)) {
        incorrectFormError.style.display = "none";
        const url = new URL('http://localhost:8080/lab2_app/main');
        url.searchParams.append('x', xMapped.toString());
        url.searchParams.append('y', yMapped.toString());
        url.searchParams.append('r', rInput.value);
        url.searchParams.append('areaClick', "true");
        fetch(url)
            .then(response => response.json())
            .then(data => {
                let resultText = "Промах";
                if (data[0]["result"]){
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
    } else {
        incorrectFormError.style.display = "none";
        rNotSelectedError.style.display = "block";
    }
});


mainForm.addEventListener("submit", (e)=>{
    e.preventDefault();
    let checkboxes = document.querySelectorAll("input[name='x']:checked");
    console.log(checkboxes);
    if (!checkY(yInput.value) || !checkR(rInput.value) || checkboxes.length===0){
        incorrectFormError.style.display = "block";
        rNotSelectedError.style.display = "none";
    } else {
        incorrectFormError.style.display = "none";
        mainForm.submit();
    }
});