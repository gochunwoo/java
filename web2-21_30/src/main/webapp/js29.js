/*
const myPromise = (seconds) => new Promise((resolve, reject) => {
    setTimeout(() => {
        let a = 2;
        if (a % 2 === 0) {
            resolve("이 값이 then 메소드의 매개변수로 전달됨");
        } else {
            reject('에러: reject이 실행되면 catch 메소드로 받을 수 있다');
        }
    }, seconds);  // 세미콜론 추가
});

async function gogo() {
    try {
        const result1 = await myPromise(1000);  // 세미콜론 추가
        console.log(result1);

        const result2 = await myPromise(2000);  // 세미콜론 추가
        console.log(result2);

        const result3 = await myPromise(1000);  // 세미콜론 추가
        console.log(result3);
    } catch (e) {
        console.log(e);
    } finally {
        console.log("good");
    }
}
*/