export default async function fetchApi(url, method, body) {
    const data = await fetch('http://localhost:6969' + url, {
        method: method,
        headers: {
            Accept: 'application/json',
            "Content-Type": "application/json",
            // "x-access-token": localStorage.getItem("token")
        },
        body: body,
    },
    )
        .then((response) => response)
        .then((responseJson) => {
            return responseJson.json()
        })
        .catch((error) => {
            throw error;
        });
    return data;
}