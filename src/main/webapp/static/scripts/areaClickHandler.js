"use strict";
async function sendAreaClickRequest(x, y, r) {
    const url = new URL('http://localhost:8080/lab2_app/main');
    url.searchParams.append('x', x);
    url.searchParams.append('y', y);
    url.searchParams.append('r', r);
    url.searchParams.append('areaClick', "true");
    return await fetch(url);
}