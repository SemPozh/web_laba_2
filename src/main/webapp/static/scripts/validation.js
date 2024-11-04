"use strict";

function validateYInput(){
    const yInput = document.getElementById("y-inp");

    if (yInput.value === ""){
        yInput.classList.remove("incorrect");
        return
    }

    if (checkY(yInput.value)){
        yInput.classList.remove("incorrect");
    } else {
        yInput.classList.add("incorrect");
    }
}

function validateRInput() {
    const rInput = document.getElementById("r-inp");

    if (rInput.value === ""){
        rInput.classList.remove("incorrect");
        clearCanvas();
        drawCoordinateLines();
        return;
    }



    if (checkR(rInput.value)){
        rInput.classList.remove("incorrect");
        rNotSelectedError.style.display = "none";
        clearCanvas();
        drawArea(parseFloat(rInput.value));
        drawCoordinateLines();
    } else {
        rInput.classList.add("incorrect");
        clearCanvas();
        drawCoordinateLines();
    }
}

function checkR(rString){
    const regex =/^((1\.0*[1-9]+[0-9]*)|([2-3]\.\d+)|([2-3]))$/;
    // Matches a number between 1 and 4, not inclusive,
    // and may have an optional decimal part.
    // Examples: "1.2", "2", "3", "3.123", "2.1234567890123456" (valid)
    // Examples: "4", "-3.123456789" (invalid)
    return regex.test(rString) && parseFloat(rString)!==1
}

function checkY(yString){
    const regex = /^(([0-2](\.\d+)?)|(-[0-4](\.\d+)?))$/;
    // Matches a number between -5 and 3, not inclusive,
    // and may have an optional decimal part.
    // Examples: "0", "1.421412", "2", "-4.9999", "-3.1", "2.1234567890123456" (valid)
    // Examples: "3", "-5.12345678901234567" (invalid)
    return regex.test(yString);
}